package companion.challeculum.domains.usermission.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserMission {
    private Long userId;
    private Long missionId;
    private LocalDate submitAt;
    private String isAccepted;
    private String imageUrl;
}
