package companion.challeculum.domains.user.userground.dtos;

import lombok.Data;

@Data
public class UserGround {
    private long userId;
    private long groundId;
    private Boolean isSuccess;
}
