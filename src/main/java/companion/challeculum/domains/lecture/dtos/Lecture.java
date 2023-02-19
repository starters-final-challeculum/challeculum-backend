package companion.challeculum.domains.lecture.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Lecture {
    private long id;
    private long categoryId;
    private String platform;
    private String title;
    private String instructor;
    private String url;

}
