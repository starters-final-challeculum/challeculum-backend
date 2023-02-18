package companion.challeculum.domains.userground;

public interface UserGroundService {

    /////////// JongHyun
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
