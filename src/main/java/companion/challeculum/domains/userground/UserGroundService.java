package companion.challeculum.domains.userground;

import companion.challeculum.domains.userground.dtos.UserGround;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;

import java.util.List;

public interface UserGroundService {

    /////////// JongHyun
    boolean isAvailableGround(Long sessionId, long groundId);
    List<UserGroundJoined> getSuccessUserList(long groundId);
    List<UserGround> getUserGroundReviewList(long groundId);
    ////////// End of JongHyun

    /////////// Kiyoung
    /////////// End of Kiyoung

    /////////// Sojeong
    /////////// End of Sojeong

    /////////// Hwajun
    ////////// End of Hwajun

    ////////// HyunJoon
    //그라운드 참여
    void participateGround(long groundId, long userId);

    //그라운드 참여 취소
    void cancelParticipateGround(long groundId, long userId);
    ////////// End of HyunJoon
}
