package companion.challeculum.domains.userground;

import companion.challeculum.domains.ground.GroundDao;
import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.user.UserDao;
import companion.challeculum.domains.user.dtos.User;
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
    UserGroundDao userGroundDao;
    @Autowired
    UserLectureDao userLectureDao;
    @Autowired
    GroundDao groundDao;
    @Autowired
    UserDao userDao;
    ////////////// end of common

    /////////////// JongHyun
    @Override
    public boolean isAvailableGround(Long sessionId, long groundId) {
        UserGroundJoined userGroundJoined = userGroundDao.getUserGroundJoined(sessionId, groundId);
        UserLecture userLecture = userLectureDao.findUserLecture(sessionId, userGroundJoined.getLectureId());
        if (userLecture == null || userGroundJoined.getIsAttending() == 1) return false;
        return true;
    }
    @Override
    public List<UserGroundJoined> getSuccessUserList(long groundId) {
        return userGroundDao.getUserGroundJoinedListByGroundId(groundId).stream().filter(userGroundJoined -> userGroundJoined.getIsSuccess() == 1).toList();
    }

    @Override
    public List<UserGround> getUserGroundReviewList(long groundId) {
        return userGroundDao.getUserGroundListByGroundId(groundId).stream().filter(userGroundJoined -> userGroundJoined.getComment() != null).toList();
    }
    /////////////// end of JongHyun


    /////////////// KiYoung
    public int getReward(long groundId){
        int Deposit= groundDao.getDepositById(groundId).getDeposit();
        int getUserGroundCount = userGroundDao.getUserGroundCountByGroundId(groundId);
        int getuserGroundSucessCount= userGroundDao.getUserGroundSuccessCountByGroundId(groundId);
        if (getuserGroundSucessCount==0){
            return 0;
        }   else{
        int depositReward= (Deposit *  getUserGroundCount) / getuserGroundSucessCount;
        return depositReward;
        }
    }

    public boolean getGroundAttend(long groundId, long userId){
        List<UserGroundJoined> userGroundJoineds = userGroundDao.getGroundAttend(groundId).stream().filter(userGroundJoined -> userGroundJoined.getIsAttending() == 1).toList();
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
        return userGroundDao.getUserGroundList(userId, groundId);
    }

    @Override
    public int reviewUserGround(long userId, long groundId, UserGroundUpdateDto userGroundUpdateDto) {
        return userGroundDao.reviewUserGround(userId, groundId, userGroundUpdateDto);
    }

    //////////////  end of Hwajun

    ///////////////HyunJoon
    //그라운드 참여할 때, user_mission테이블에도 값 넣어야되겠네???
    //참여 취소하면 다시 지우고
    //아님 그라운드 시작하면 그때 미션을 넣든가

    //그라운드 참여
    @Override
    public void createUserGround(long groundId, long userId) {


        // 1. 처음 참여하는 거면 insert문으로, 참여 취소했다 다시 참여하는 거면 update
        // 2. 그라운드 참여하기 전에 조건3가지
        //  2-1 최대 수용인원(max_capacity)이 다 찼는지
        //  2-2 예치금이 있는지 확인
        //  2-3 내가 수강하고있는 lecture의 그라운드인지

        //userGroundJoined, ground 값 가져오기
        UserGroundJoined userGroundJoined = userGroundDao.getUserGroundJoined(userId, groundId);
        Ground ground = groundDao.getGround(groundId);
//        User user = userDao.getUser(userId);

        //userGroundJoined == null이면 처음 참가하는 것
        System.out.println(userGroundJoined);
        System.out.println(ground);


        int maxCapacity = ground.getMaxCapacity(); // ground 최대 수용인원
        int currentParticipant = userGroundDao.countParticipant(groundId); // ground 현재 참여 인원

        int deposit = ground.getDeposit();
        int myPoint = userGroundDao.getPoint(userId);

        long lectureId = ground.getLectureId();
        int onDoingLecture = userGroundDao.getOnDoingLecture(lectureId, userId); //유저가 수강하고 있는 lecture인지 맞으면 1, 아니면 0

        System.out.println(maxCapacity + " " + currentParticipant);
        System.out.println(deposit + " " + myPoint);
        System.out.println(onDoingLecture);

        //2-1 최대 수용인원이 다 찼는지
        if (currentParticipant >= maxCapacity) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "그라운드 참여 인원 초과");
        }
        //2-2 예치금이 있는지 확인
        if (deposit > myPoint) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "point가 부족합니다.");
        }
        //2-3 내가 수강하고 있는 lecture의 그라운드 인지
        if (onDoingLecture != 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "유저가 수강하는 그라운드가 아닙니다.");
        }


        if(userGroundJoined == null){ //처음 참가하는 거면 insert
            userGroundDao.participateGround(groundId, userId);
            userGroundDao.deductDeposit(groundId, userId);
        }
        else{ //참가 기록이 있으면 조건 확인 후 is_attending 0 --> 1 로 변경
            if(userGroundJoined.getIsAttending() == 0){
                userGroundDao.participateGroundUpdate(groundId, userId);
                userGroundDao.deductDeposit(groundId, userId);
            }

        }
    }

    //그라운드 참여 취소
    public void changeUserGround(long groundId, long userId) {

        //조건
        // 1. user_ground테이블의 is_attending = 1이면 실행
        // 2.그라운드 참여 취소 시 is_attending = 0, user의 예치금 다시 받기

        //userGroundJoined, ground 값 가져오기
        UserGroundJoined userGroundJoined = userGroundDao.getUserGroundJoined(userId, groundId);

        if(userGroundJoined.getIsAttending() == 1) { // is_attending = 1 이면 실행
            userGroundDao.changeUserGround(groundId, userId);
            userGroundDao.receiveDeposit(groundId, userId);
        }
    }
    /////////////////end of HyunJoon
}
