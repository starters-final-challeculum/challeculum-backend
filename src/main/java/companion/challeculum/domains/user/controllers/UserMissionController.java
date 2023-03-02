package companion.challeculum.domains.user.controllers;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.user.dto.UserMission;
import companion.challeculum.domains.user.repositories.UserMissionDao;
import companion.challeculum.domains.user.services.UserMissionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
@RequestMapping("/api/v1/user")
public class UserMissionController {
    private final AmazonS3 amazonS3;
    private final UserMissionDao userMissionDao;
    private final String bucketName;
    private final AuthUserManager authUserManager;
    private final UserMissionService userMissionService;

    public UserMissionController(AmazonS3 amazonS3, UserMissionDao userMissionDao, @Value("${cloud.aws.s3.bucket}") String bucketName, AuthUserManager authUserManager, UserMissionService userMissionService) {
        this.amazonS3 = amazonS3;
        this.userMissionDao = userMissionDao;
        this.bucketName = bucketName;
        this.authUserManager = authUserManager;
        this.userMissionService = userMissionService;
    }

    @PostMapping("/me/mission/{missionId}")
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

            // UserMission 객체 생성
            UserMission userMission = new UserMission();
            userMission.setUserId(authUserManager.getSessionId(authentication));
            userMission.setMissionId(missionId);
            userMission.setImageUrl(fileUrl);

            // UserMissionFile 객체를 데이터베이스에 저장
            userMissionDao.createUserMission(userMission);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/me/mission/{missionId}")
    public void updateUserMission(@RequestBody UserMission userMission, Authentication authentication, @PathVariable long missionId) {
        long userId = authUserManager.getSessionId(authentication);
        userMissionService.updateUserMission(userMission, userId, missionId);
    }

    @PutMapping("/{userId}/mission/{missionId}")
    public void updateUserMission(@RequestBody UserMission userMission, @PathVariable long userId, @PathVariable long missionId) {
        userMissionService.updateUserMissionByAdmin(userMission, userId, missionId);
    }



    @GetMapping("/me/all")
    public List<UserMission> getAllUserMission(Authentication authentication){
        return userMissionService.getAllUserMission(authentication);
    }

    @GetMapping("/me/mission/{missionId}")
    public UserMission getUserMission(Authentication authentication, @PathVariable long missionId){
        return userMissionService.getUserMission(authUserManager.getSessionId(authentication), missionId);
    }
}


