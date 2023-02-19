package companion.challeculum.domains.userlecture.dtos;

import companion.challeculum.domains.lecture.dtos.Lecture;
import companion.challeculum.domains.user.dtos.UserInfoDto;
import lombok.Data;

@Data
public class UserLectureJoined {
    private final long id;
    private final long userId;
    private final long lectureId;
    private final boolean isCompleted;

    // user
    private final String oauthId;
    private final String username;
    private final String password;
    private final String nickname;
    private final String phone;
    private final int point;
    private final int missionScore;
    private final String role;

    //lecture
    private final long categoryId;
    private final String platform;
    private final String title;
    private final String instructor;
    private final String url;

    public UserInfoDto toUserInfo(){
        return new UserInfoDto(userId, username, nickname, phone, point, missionScore);
    }

    public Lecture toLecture(){
        Lecture lecture = new Lecture();
        lecture.setId(lectureId);
        lecture.setCategoryId(categoryId);
        lecture.setPlatform(platform);
        lecture.setTitle(title);
        lecture.setInstructor(instructor);
        lecture.setUrl(url);
        return lecture;
    }
}
