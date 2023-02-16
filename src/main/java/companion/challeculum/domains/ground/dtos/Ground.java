package companion.challeculum.domains.ground.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Ground {
    long id;
    long lectureId;
    String title;
    String information;
    int level;
    int maxCapacity;
    int deposit;
    int isValidated;
    int isPremium;
    LocalDateTime createdAt;
    LocalDate startAt;
    LocalDate endAt;
    LocalDateTime validatedAt;
    String status;
    int missionFailLimit;
}
