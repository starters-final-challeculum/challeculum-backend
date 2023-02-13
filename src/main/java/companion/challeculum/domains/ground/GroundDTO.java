package companion.challeculum.domains.ground;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class GroundDTO{
    long id;
    long lectureId;
    long categoryId;
    String title;
    String information;
    int level;
    int capacity;
    int deposit;
    int isValidated;
    int isPremium;
    LocalDateTime createdAt;
    LocalDate startAt;
    LocalDate endAt;
    LocalDateTime validatedAt;
    String status;
    int dropCount;


}
