package companion.challeculum.domains.lecture.dtos;

import lombok.Data;

@Data
public class LectureCreateDto {

    private final long categoryId;
    private final String platform;
    private final String title;
    private final String instructor;
    private final String url;
}
