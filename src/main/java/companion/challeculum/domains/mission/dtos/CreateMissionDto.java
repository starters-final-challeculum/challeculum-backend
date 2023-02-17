package companion.challeculum.domains.mission.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created by jonghyeon on 2023/02/16,
 * Package : companion.challeculum.domains.mission.dtos
 */
@Data
public class CreateMissionDto {
    private final Long groundId;
    private final String assignment;
    private final LocalDate startAt;
    private final LocalDate endAt;
}
