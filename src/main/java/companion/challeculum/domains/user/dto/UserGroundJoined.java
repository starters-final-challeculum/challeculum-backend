package companion.challeculum.domains.user.dto;

import companion.challeculum.domains.ground.dto.Ground;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.userground.dtos
 */
@Data
public class UserGroundJoined {
    private Boolean isSuccess;

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

    //User
    private final long userId;
    private String oauthId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int point;
    private int missionScore;
    private String role;

    public UserInfoDto toUserInfo() {
        return new UserInfoDto(userId, username, nickname, phone, point, missionScore, isSuccess);
    }

    public Ground toGround() {
        Ground ground = new Ground();
        ground.setGroundId(groundId);
        ground.setLectureId(lectureId);
        ground.setInformation(information);
        ground.setMinCapacity(minCapacity);
        ground.setDeposit(deposit);
        ground.setCreatedAt(createdAt);
        ground.setStartAt(startAt);
        ground.setEndAt(endAt);
        ground.setStatus(status);
        return ground;
    }
}
