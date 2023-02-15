package companion.challeculum.domains.userground;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserGroundDAO {

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
}