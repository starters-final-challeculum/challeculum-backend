package companion.challeculum.domains.userground.dtos;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.user.dtos.UserInfoDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.userground.dtos
 */
@Data
public class UserGroundJoined {
    private long id;
    private long userId;
    private long groundId;
    private int isAttending;
    private int isSuccess;
    private int rating;
    private String comment;
    //user
    private String oauthId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int point;
    private int missionScore;
    private String role;
    //ground
    private long createdBy;
    private long lectureId;
    private String title;
    private String information;
    private int level;
    private int minCapacity;
    private int maxCapacity;
    private int deposit;
    private int isValidated;
    private int isPremium;
    private LocalDateTime createdAt;
    private LocalDate startAt;
    private LocalDate endAt;
    private LocalDateTime validatedAt;
    private String status;
    private int missionFailLimit;

    public UserInfoDto toUserInfo(){
        return new UserInfoDto(userId, username, nickname, phone, point, missionScore);
    }

    public Ground toGround(){
        Ground ground = new Ground();
        ground.setId(groundId);
        ground.setUserId(createdBy);
        ground.setLectureId(lectureId);
        ground.setTitle(title);
        ground.setInformation(information);
        ground.setLevel(level);
        ground.setMinCapacity(minCapacity);
        ground.setMaxCapacity(maxCapacity);
        ground.setDeposit(deposit);
        ground.setIsValidated(isValidated);
        ground.setIsPremium(isPremium);
        ground.setCreatedAt(createdAt);
        ground.setStartAt(startAt);
        ground.setEndAt(endAt);
        ground.setValidatedAt(validatedAt);
        ground.setStatus(status);
        ground.setMissionFailLimit(missionFailLimit);
        return ground;
    }
}
