package companion.challeculum.domains.usermission.dtos;

import companion.challeculum.domains.mission.dtos.Mission;
import companion.challeculum.domains.user.dtos.UserInfoDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserMissionJoined {
    private LocalDate submitAt;
    private String isAccepted;
    private String imageUrl;

    //User
    private long userId;
    private String oauthId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int point;
    private int missionScore;
    private String role;

    //Mission
    private long missionId;
    private long groundId;
    private String assignment;
    private LocalDate missionAt;

    public UserInfoDto toUserInfo(){
        return new UserInfoDto(userId, username, nickname, phone, point, missionScore, null);
    }

    public Mission toMission(){
        Mission mission = new Mission();
        mission.setGroundId(groundId);
        mission.setAssignment(assignment);
        mission.setMissionAt(missionAt);
        return mission;
    }


}
