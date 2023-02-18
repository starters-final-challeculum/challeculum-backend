package companion.challeculum.domains.userlecture.dtos;

import lombok.Data;

@Data
public class UserLecture {
    private long id;
    private long userId;
    private long lectureId;

}
