package companion.challeculum.domains.mission.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by jonghyeon on 2023/02/16,
 * Package : companion.challeculum.domains.mission.dtos
 */
@Data
public class MissionCreateDto {
    private long groundId;
    private String assignment;
    private LocalDate missionAt;
}
