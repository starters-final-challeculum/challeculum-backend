package companion.challeculum.domains.usermission.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserMission {
    private long userId;
    private long missionId;
    private LocalDate submitAt;
    private String isAccepted;
    private String imageUrl;

}
