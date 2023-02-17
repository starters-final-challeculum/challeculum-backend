package companion.challeculum.domains.ground.dtos;

import companion.challeculum.domains.mission.dtos.CreateMissionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Setter
@Getter
public class CreateGroundDto {
    private long lectureId;
    private String title;
    private String information;
    private int level;
    private int maxCapacity;
    private int deposit;
    private LocalDate startAt;
    private LocalDate endAt;
    private int missionFailLimit;
    private List<CreateMissionDto> missionList;
    private long createdBy;
}
