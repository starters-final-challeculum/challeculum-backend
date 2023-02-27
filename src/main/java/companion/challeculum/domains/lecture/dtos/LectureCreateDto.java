package companion.challeculum.domains.lecture.dtos;

import lombok.Data;

@Data
public class LectureCreateDto {
    private final String categoryName;
    private final String platform;
    private final String lectureTitle;
    private final String instructor;
    private final String url;
}
