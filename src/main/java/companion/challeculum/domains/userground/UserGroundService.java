package companion.challeculum.domains.userground;

public interface UserGroundService {

    //그라운드 참여
    void participateGround(long groundId, long userId);

    //그라운드 참여 취소
    void cancelParticipateGround(long groundId, long userId);

}
