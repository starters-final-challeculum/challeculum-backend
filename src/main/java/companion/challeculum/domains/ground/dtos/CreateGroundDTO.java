package companion.challeculum.domains.ground.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Data
public class CreateGroundDTO {
    long lectureId;
    String title;
    String information;
    int level;
    int maxCapacity;
    int deposit;
    LocalDate startAt;
    LocalDate endAt;
    int missionFailLimit;
    List<Map<String, String>> missionList;
    long createdBy;


}
