package companion.challeculum.domains.userground;

import lombok.Data;

@Data
public class UserGroundDTO {

    long id;
    long userId;
    long groundId;
    int isAttending;
    int isSuccess;
    int rating;
    String comment;
//    long prev_point;
//    long after_point;

}
