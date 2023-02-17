package companion.challeculum.domains.ground.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Ground {
    private final long id;
    private final long lectureId;
    private final String title;
    private final String information;
    private final int level;
    private final int maxCapacity;
    private final int deposit;
    private final int isValidated;
    private final int isPremium;
    private final LocalDateTime createdAt;
    private final LocalDate startAt;
    private final LocalDate endAt;
    private final LocalDateTime validatedAt;
    private final String status;
    private final int missionFailLimit;
}
