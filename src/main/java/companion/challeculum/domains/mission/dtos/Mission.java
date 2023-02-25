package companion.challeculum.domains.mission.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Mission {
    private long missionId;
    private long groundId;
    private String assignment;
    private LocalDate missionAt;
}
