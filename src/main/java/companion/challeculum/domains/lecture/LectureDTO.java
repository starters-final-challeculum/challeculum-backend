package companion.challeculum.domains.lecture;

import lombok.Data;

@Data
public class LectureDTO {

    long id;
    long categoryId;
    String platform;
    String title;
    String instructor;
    String url;

}
