package companion.challeculum.domains.lecture.dtos;

import lombok.Data;

@Data
public class Lecture {

    long id;
    long categoryId;
    String platform;
    String title;
    String instructor;
    String url;

}
