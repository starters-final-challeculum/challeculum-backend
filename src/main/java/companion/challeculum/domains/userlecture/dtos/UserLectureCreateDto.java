package companion.challeculum.domains.userlecture.dtos;

import lombok.Data;

@Data
public class UserLectureCreateDto {

    private long userId;
    private long lectureId;
}
