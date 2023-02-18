package companion.challeculum.domains.userground.dtos;

import lombok.Data;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.userground.dtos
 */
@Data
public final class UserGroundUpdateDto {
    private final long id;
    private final int isAttending;
    private final int isSuccess;
    private final int rating;
    private final String comment;
}
