package companion.challeculum.domains.ground.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.ground.dtos
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroundUpdateDto {
    private final String title;
    private final String information;
    private final Integer level;
    private final Integer minCapacity;
    private final Integer maxCapacity;
    private final Integer deposit;
    private final Integer isValidated;
    private final LocalDate startAt;
    private final LocalDate endAt;
    private final LocalDateTime validatedAt;
    private final String status;
    private final Integer missionFailLimit;
}
