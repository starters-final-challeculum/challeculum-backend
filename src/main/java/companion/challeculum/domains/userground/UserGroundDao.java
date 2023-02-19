package companion.challeculum.domains.userground;

import companion.challeculum.domains.userground.dtos.UserGround;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;
import companion.challeculum.domains.userground.dtos.UserGroundUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserGroundDao {

    /////////// JongHyun
    UserGround getUserGround(long userId, long groundId);
    UserGroundJoined getUserGroundJoined(long userId, long groundId);
    List<UserGround> getUserGroundListByGroundId(long groundId);
    List<UserGroundJoined> getUserGroundJoinedListByGroundId(long groundId);
    ////////// End of JongHyun

    /////////// Kiyoung
    /////////// End of Kiyoung

    /////////// Sojeong
    /////////// End of Sojeong

    /////////// Hwajun
    List<UserGroundJoined> getUserGroundList(long userId, long groundId);

    int reviewUserGround(long userId, UserGroundUpdateDto userGroundUpdateDto);
    ////////// End of Hwajun

    /////////// HyunJoon
    //그라운드 참여 sql
    void participateGround(long groundId, long userId);

    void participateGroundUpdate(long groundId, long userId);

    //그라운드 참여 시 예치금 뺴기
    void deductDeposit(long groundId, long userId);

    //최대 수용인원 select
    int getMaxCapacity(long groundId);

    //현재 참여 인원 count
    int countParticipant(long groundId);

    //예치금 확인
    int getDeposit(long groundId);

    //내 포인트 확인
    int getPoint(long userId);

    //내가 수강중인 lecture 확인
    int getOnDoingLecture(long groundId, long userId);

    //처음 신청하는 것인지 확인
    int checkFirstParticipant(long groundId, long userId);

    //그라운드 참여 취소
    void cancelParticipateGround(long groundId, long userId);

    //예치금 다시 받기
    void receiveDeposit(long groundId, long userId);
    //////////// End of Hyunjoon
}