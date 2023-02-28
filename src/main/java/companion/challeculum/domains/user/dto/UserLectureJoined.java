package companion.challeculum.domains.user.dto;

import companion.challeculum.domains.lecture.dto.Lecture;
import lombok.Data;

@Data
public class UserLectureJoined {
    //    private long id;
    private long userId;
    private long lectureId;


    // user
    private String oauthId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int point;
    private int missionScore;
    private String role;

    //lecture
    private String categoryName;
    private String platform;
    private String lectureTitle;
    private String instructor;
    private String url;

    public UserInfoDto toUserInfo() {
        return new UserInfoDto(userId, username, nickname, phone, point, missionScore, null);
    }

    public Lecture toLecture() {
        Lecture lecture = new Lecture();
        lecture.setLectureId(lectureId);
        lecture.setCategoryName(categoryName);
        lecture.setPlatform(platform);
        lecture.setLectureTitle(lectureTitle);
        lecture.setInstructor(instructor);
        lecture.setUrl(url);
        return lecture;
    }
}
