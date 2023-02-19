package companion.challeculum.domains.ground.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Ground {
    private long id;
    private long userId;
    private long lectureId;
    private String title;
    private String information;
    private int level;
    private int minCapacity;
    private int maxCapacity;
    private int deposit;
    private int isValidated;
    private int isPremium;
    private LocalDateTime createdAt;
    private LocalDate startAt;
    private LocalDate endAt;
    private LocalDateTime validatedAt;
    private String status;
    private int missionFailLimit;
}
