package companion.challeculum.domains.ground.dtos;

import companion.challeculum.domains.mission.dtos.MissionCreateDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class GroundCreateDto {
    private Long groundId; // 자동 생성된 키 값을 저장할 프로퍼티
    private Long createUserId;
    private Long lectureId;
    private String groundTitle;
    private String information;
    private Integer minCapacity;
    private Integer deposit;
    private LocalDate startAt;
    private LocalDate endAt;
    private List<MissionCreateDto> missionList;
}
