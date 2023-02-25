package companion.challeculum.domains.userground.dtos;

import lombok.Data;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.userground.dtos
 */

//UserGroundUpdateDto -> Comment
@Data
public class Review {
    private long userId;
    private long groundId;
    private int rating;
    private String comment;
}
