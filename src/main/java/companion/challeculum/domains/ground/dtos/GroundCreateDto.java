package companion.challeculum.domains.ground.dtos;

import companion.challeculum.domains.mission.dtos.MissionCreateDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@RequiredArgsConstructor
public class GroundCreateDto {
    private long userId;
    private final long lectureId;
    private final String title;
    private final String information;
    private final int level;
    private final int maxCapacity;
    private final int deposit;
    private final LocalDate startAt;
    private final LocalDate endAt;
    private final int missionFailLimit;
    private final List<MissionCreateDto> missionList;
}
