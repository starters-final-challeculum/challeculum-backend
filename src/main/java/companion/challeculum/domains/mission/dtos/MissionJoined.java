package companion.challeculum.domains.mission.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MissionJoined {
    private long missionId;
    private long groundId;
    private String assignment;
    private LocalDate missionAt;

    //ground
    private long createUserId;
    private long lectureId;
    private String groundTitle;
    private String information;
    private int minCapacity;
    private int deposit;
    private LocalDateTime createdAt;
    private LocalDate startAt;
    private LocalDate endAt;
    private String status;
}
