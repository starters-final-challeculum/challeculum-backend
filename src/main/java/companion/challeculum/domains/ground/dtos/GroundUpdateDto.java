package companion.challeculum.domains.ground.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.ground.dtos
 */
@Data
@AllArgsConstructor
public class GroundUpdateDto {
    private final long groundId;
    private final long createUserId;
    private final long lectureId;
    private String groundTitle;
    private String information;
    private int minCapacity;
    private int deposit;
    private LocalDate startAt;
    private LocalDate endAt;
    private String status;
}
