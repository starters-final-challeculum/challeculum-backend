package companion.challeculum.domains.userground.dtos;

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
    private long lectureId;
    private String title;
    private String information;
    private int level;
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
}
