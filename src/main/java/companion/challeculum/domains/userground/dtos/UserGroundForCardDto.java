package companion.challeculum.domains.userground.dtos;

import lombok.Data;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.userground.dtos
 */
@Data
public final class UserGroundForCardDto {
    private final String title;
    private final int expectedReward;
    private final String missionToday;
    private final int dDay;
}
