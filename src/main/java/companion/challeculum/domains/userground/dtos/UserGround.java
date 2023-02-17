package companion.challeculum.domains.userground.dtos;

import lombok.Data;

@Data
public class UserGround {

    private long id;
    private long userId;
    private long groundId;
    private int isAttending;
    private int isSuccess;
    private int rating;
    private String comment;

    public UserGroundUpdateDto toUpdateDto(){
        return new UserGroundUpdateDto(isAttending, isSuccess, rating, comment);
    }
}
