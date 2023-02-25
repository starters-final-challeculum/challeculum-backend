package companion.challeculum.domains.userground.dtos;

import lombok.Data;

@Data
public class UserGround {
    private long userId;
    private long groundId;
    private boolean isSuccess;
}
