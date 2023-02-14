package companion.challeculum.domains.userground;

import lombok.Data;

@Data
public class UserGroundDTO {

    long id;
    long user_id;
    long ground_id;
    int is_attending;
    int is_success;
    int rating;
    String comment;
//    long prev_point;
//    long after_point;

}
