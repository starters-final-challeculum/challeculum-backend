package companion.challeculum.domains.usermission;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import companion.challeculum.domains.usermission.dtos.UserMission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/usermission")
public class UserMissionController {

    private final AmazonS3 amazonS3;
    private final UserMissionDao userMissionDao;
    private final String bucketName;

    @Autowired
    public UserMissionController(AmazonS3 amazonS3, UserMissionDao userMissionDao, @Value("${cloud.aws.s3.bucket}") String bucketName) {
        this.amazonS3 = amazonS3;
        this.userMissionDao = userMissionDao;
        this.bucketName = bucketName;
    }

    @PostMapping
    public ResponseEntity<Object> insertFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") int userId,
                                             @RequestParam("missionId") int missionId) {
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
            userMissionFile.setUserId((long) userId);
            userMissionFile.setMissionId((long) missionId);
            userMissionFile.setImageUrl(fileUrl);

            // UserMissionFile 객체를 데이터베이스에 저장
            userMissionDao.createUserMission(userMissionFile);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
