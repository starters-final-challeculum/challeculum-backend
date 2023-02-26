package companion.challeculum.domains.usermission;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.mission.dtos.Mission;
import companion.challeculum.domains.usermission.dtos.UserMission;
import companion.challeculum.security.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/usermission")
public class UserMissionController {
    private final AmazonS3 amazonS3;
    private final UserMissionDao userMissionDao;
    private final String bucketName;

    private final AuthUserManager authUserManager;
    private final UserMissionService userMissionService;

    @Autowired
    public UserMissionController(AmazonS3 amazonS3, UserMissionDao userMissionDao, @Value("${cloud.aws.s3.bucket}") String bucketName, AuthUserManager authUserManager, UserMissionService userMissionService) {
        this.amazonS3 = amazonS3;
        this.userMissionDao = userMissionDao;
        this.bucketName = bucketName;
        this.authUserManager = authUserManager;
        this.userMissionService = userMissionService;
    }

    @PostMapping("/{missionId}")
    public ResponseEntity<Object> insertFile(@RequestParam("file") MultipartFile file, Authentication authentication,
                                             @PathVariable long missionId) {
        try {
            // S3에 파일 업로드
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            amazonS3.putObject(bucketName, fileName, file.getInputStream(), metadata);

            // 파일 URL 생성
            String fileUrl = amazonS3.getUrl(bucketName, fileName).toString();

            // UserMissionFile 객체 생성
            UserMission userMissionFile = new UserMission();
            long userId = ((PrincipalDetails) authentication.getPrincipal()).getUser().getUserId();
            userMissionFile.setUserId(userId);
            userMissionFile.setMissionId(missionId);
            userMissionFile.setImageUrl(fileUrl);

            // UserMissionFile 객체를 데이터베이스에 저장
            userMissionDao.createUserMission(userMissionFile);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public UserMission updateUserMission(@RequestBody UserMission userMission, Authentication authentication){
        long userId = ((PrincipalDetails) authentication.getPrincipal()).getUser().getUserId();
        userMissionService.updateUserMission(userMission,userId,userMission.getMissionId());
        return userMissionService.getUserMissionByUserId(userId,userMission.getMissionId());
        }

    }


