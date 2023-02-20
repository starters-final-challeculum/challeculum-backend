package companion.challeculum.domains.userground;

import companion.challeculum.domains.ground.GroundDao;
import companion.challeculum.domains.userground.dtos.UserGround;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;
import companion.challeculum.domains.userground.dtos.UserGroundUpdateDto;
import companion.challeculum.domains.userlecture.UserLectureDao;
import companion.challeculum.domains.userlecture.dtos.UserLecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service("usergroundservice")
@Transactional // db transaction
public class UserGroundServiceImpl implements UserGroundService {
    /////////////// common
    @Autowired
    UserGroundDao dao;
    @Autowired
    UserLectureDao userLectureDao;
    @Autowired
    GroundDao groundDao;
    ////////////// end of common

    /////////////// JongHyun
    @Override
    public boolean isAvailableGround(Long sessionId, long groundId) {
        UserGroundJoined userGroundJoined = dao.getUserGroundJoined(sessionId, groundId);
        UserLecture userLecture = userLectureDao.findUserLecture(sessionId, userGroundJoined.getLectureId());
        if (userLecture == null || userGroundJoined.getIsAttending() == 1) return false;
        return true;
    }
    @Override
    public List<UserGroundJoined> getSuccessUserList(long groundId) {
        return dao.getUserGroundJoinedListByGroundId(groundId).stream().filter(userGroundJoined -> userGroundJoined.getIsSuccess() == 1).toList();
    }

    @Override
    public List<UserGround> getUserGroundReviewList(long groundId) {
        return dao.getUserGroundListByGroundId(groundId).stream().filter(userGroundJoined -> userGroundJoined.getComment() != null).toList();
    }
    /////////////// end of JongHyun


    /////////////// KiYoung
    public int getReward(long groundId){
        int Deposit= groundDao.getDepositById(groundId).getDeposit();
        int getUserGroundCount = dao.getUserGroundCountByGroundId(groundId);
        int getuserGroundSucessCount= dao.getUserGroundSuccessCountByGroundId(groundId);
        int depositReward= (Deposit *  getUserGroundCount) / getuserGroundSucessCount;
        return depositReward;
    }

    public boolean getGroundAttend(long groundId, long userId){
        List<UserGroundJoined> userGroundJoineds = dao.getGroundAttend(groundId).stream().filter(userGroundJoined -> userGroundJoined.getIsAttending() == 1).toList();
        List<UserGroundJoined> userGroundFiltered= userGroundJoineds.stream().filter(userGroundJoined -> userGroundJoined.getUserId() == userId).toList();
        if(userGroundFiltered.size()==0){
            return true;
        }
        else {
            return false;
        }
    }
    ///////////////  end of KiYoung

    /////////////// Sojeong

    ///////////////  end of Sojeong

    /////////////// Hwajun
    @Override
    public List<UserGroundJoined> getUserGroundList(long userId, long groundId) {
        return dao.getUserGroundList(userId, groundId);
    }

    @Override
    public int reviewUserGround(long userId, UserGroundUpdateDto userGroundUpdateDto) {
        return dao.reviewUserGround(userId, userGroundUpdateDto);
    }

    //////////////  end of Hwajun

    ///////////////HyunJoon
    //그라운드 참여
    @Override
    public void participateGround(long groundId, long userId) {


        // 1. 처음 참여하는 거면 insert문으로 참여 취소했다 다시 참여하는 거면 update
        // 2. 그라운드 참여하기 전에 조건3가지
        //  2-1 최대 수용인원(max_capacity)이 다 찼는지
        //  2-2 예치금이 있는지 확인
        //  2-3 내가 수강하고있는 lecture의 그라운드인지
        int max_capacity = dao.getMaxCapacity(groundId);
        int current_participant = dao.countParticipant(groundId);

        int deposit = dao.getDeposit(groundId);
        int myPoint = dao.getPoint(userId);

        //수강중인 lecture인지
        int onDoingLecture = dao.getOnDoingLecture(groundId, userId);
        int firstParticipant = dao.checkFirstParticipant(groundId, userId);

        System.out.println(max_capacity + " " + current_participant);
        System.out.println(deposit + " " + myPoint);
        System.out.println(onDoingLecture);
        System.out.println(firstParticipant);

        //2-1 최대 수용인원이 다 찼는지
        if (current_participant >= max_capacity) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "그라운드 참여 인원 초과");
        }
        //2-2 예치금이 있는지 확인
        if (deposit > myPoint) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "point가 부족합니다.");
        }
        //2-3 내가 수강하고 있는 lecture의 그라운드 인지
        if (onDoingLecture != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "유저가 수강하는 그라운드가 아닙니다.");
        }


        //조건 3가지
        if (current_participant < max_capacity && deposit <= myPoint && onDoingLecture == 0) {
            //처음 참여하는 거면 insert문으로 참여 취소했다 다시 참여하는 거면 update
            if (firstParticipant >= 1) { //update
                //update
                System.out.println("참여 with update");
                dao.participateGroundUpdate(groundId, userId);
                dao.deductDeposit(groundId, userId);
            } else {
                //insert
                System.out.println("참여 with insert");
                dao.participateGround(groundId, userId);
                dao.deductDeposit(groundId, userId);
            }
        } else { //
        }
    }

    //그라운드 참여 취소
    public void cancelParticipateGround(long groundId, long userId) {

        // user_ground테이블의 is_attending = 0
        // user의 예치금 다시 받기
        dao.cancelParticipateGround(groundId, userId);
        dao.receiveDeposit(groundId, userId);
    }
    /////////////////end of HyunJoon
}
