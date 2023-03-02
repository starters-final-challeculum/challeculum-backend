package companion.challeculum.domains.user.dto;

import companion.challeculum.domains.ground.dto.Ground;
import companion.challeculum.domains.mission.dto.Mission;
import lombok.Data;

/**
 * Created by jonghyeon on 2023/03/02,
 * Package : companion.challeculum.domains.user.dto
 */
@Data
public class UserMissionExtended {
    User user;
    Mission mission;
    Ground ground;
}
