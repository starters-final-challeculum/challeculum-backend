package companion.challeculum.domains.mission.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MissionJoined {
    private long id;
    private long groundId;
    private String assignment;
    private LocalDate missionStartAt;
    private LocalDate missionEndAt;

    //ground
    private long lectureId;
    private String title;
    private String information;
    private int level;
    private int maxCapacity;
    private int deposit;
    private int isValidated;
    private int isPremium;
    private LocalDateTime createdAt;
    private LocalDate groundStartAt;
    private LocalDate groundEndAt;
    private LocalDateTime validatedAt;
    private String status;
    private int missionFailLimit;
}
