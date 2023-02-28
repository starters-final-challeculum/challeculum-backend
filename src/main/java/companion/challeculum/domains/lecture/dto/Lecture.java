package companion.challeculum.domains.lecture.dto;

import lombok.Data;

@Data
public class Lecture {
    private long lectureId;
    private String categoryName;
    private String platform;
    private String lectureTitle;
    private String instructor;
    private String url;

}
