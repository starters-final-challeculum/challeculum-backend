package companion.challeculum.domains.ground.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.ground.dtos
 */
@Data
public class GroundUpdateDto {
    private final String title;
    private final String information;
    private final int level;
    private final int minCapacity;
    private final int maxCapacity;
    private final int deposit;
    private final int isValidated;
    private final LocalDate startAt;
    private final LocalDate endAt;
    private final LocalDateTime validatedAt;
    private final String status;
    private final int missionFailLimit;
}
