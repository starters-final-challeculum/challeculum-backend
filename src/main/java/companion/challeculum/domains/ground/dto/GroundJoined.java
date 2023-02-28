package companion.challeculum.domains.ground.dto;

import companion.challeculum.domains.mission.dto.Mission;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class GroundJoined {
    //Ground
    private long groundId;
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

    //Lecture
    private String categoryName;
    private String platform;
    private String lectureTitle;
    private String instructor;
    private String url;

    //Others
    private int numOfParticipants;
    private List<Mission> missionList;
}
