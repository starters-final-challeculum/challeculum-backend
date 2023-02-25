package companion.challeculum.domains.ground.dtos;

import companion.challeculum.domains.mission.dtos.Mission;
import companion.challeculum.domains.mission.dtos.MissionCreateDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@RequiredArgsConstructor
public class GroundCreateDto {
    private long createUserId;
    private long lectureId;
    private String groundTitle;
    private String information;
    private int minCapacity;
    private int deposit;
    private LocalDate startAt;
    private LocalDate endAt;
    private List<MissionCreateDto> missionList;
}
