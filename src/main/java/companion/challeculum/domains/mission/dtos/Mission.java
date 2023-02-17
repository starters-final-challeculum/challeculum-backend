package companion.challeculum.domains.mission.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Mission {
    private Long id;
    private Long groundId;
    private String assignment;
    private LocalDate startAt;
    private LocalDate endAt;
}
