package companion.challeculum.domains.userground;

import companion.challeculum.domains.userground.dtos.UserGround;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;
import companion.challeculum.domains.userground.dtos.UserGroundUpdateDto;

import java.util.List;

public interface UserGroundService {

    /////////// JongHyun
    boolean isAvailableGround(Long sessionId, long groundId);
    List<UserGroundJoined> getSuccessUserList(long groundId);
    List<UserGround> getUserGroundReviewList(long groundId);
    ////////// End of JongHyun

    /////////// Kiyoung
    int getReward(long groundId);
    boolean getGroundAttend(long groundId,long userId);
    /////////// End of Kiyoung

    /////////// Sojeong
    /////////// End of Sojeong

    /////////// Hwajun
    List<UserGroundJoined> getUserGroundList(long userId, long groundId);

    int reviewUserGround(long userId, long groundId, UserGroundUpdateDto userGroundUpdateDto);
    ////////// End of Hwajun

    ////////// HyunJoon
    //그라운드 참여
    void createUserGround(long groundId, long userId);

    //그라운드 참여 취소
    void changeUserGround(long groundId, long userId);
    ////////// End of HyunJoon
}
