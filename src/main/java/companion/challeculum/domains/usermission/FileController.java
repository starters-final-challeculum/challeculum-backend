package companion.challeculum.domains.usermission;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
public class FileController {

    @Autowired
    private AmazonS3Service amazonS3Service;

    @Autowired
    private MyBatisMapper myBatisMapper;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileUrl = amazonS3Service.uploadFile(file);
        myBatisMapper.insertFile(5, 2, LocalDate.parse("2022-10-22"), "waiting",fileUrl);
        return ResponseEntity.ok("File uploaded successfully with URL: " + fileUrl);
    }
}

