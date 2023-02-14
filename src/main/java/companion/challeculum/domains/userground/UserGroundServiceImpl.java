package companion.challeculum.domains.userground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usergroundservice")
@Transactional // db transaction
public class UserGroundServiceImpl implements UserGroundService{

    @Autowired
    UserGroundDAO dao;

    //그라운드 참여
    @Override
    public void participateGround(long groundId, long userId){


        // 그라운드 참여하기 전에 조건3가지
        // 최대 수용인원(max_capacity)이 다 찼는지, 예치금이 있는지 확인, 내가 수강하고있는 lecture의 그라운드인지
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

        //조건 3가지
        if(current_participant < max_capacity && deposit <= myPoint && onDoingLecture == 0)
        {
            //처음 참여하는 거면 insert문으로 참여 취소했다 다시 참여하는 거면 update
            if(firstParticipant >= 1){ //update
                //update
                System.out.println("참여 with update");
                dao.participateGroundUpdate(groundId, userId);
                dao.deductDeposit(groundId, userId);
            }
            else{
                //insert
                System.out.println("참여 with insert");
                dao.participateGround(groundId, userId);
                dao.deductDeposit(groundId, userId);
            }
        }
        else { //

        }

    }

    //그라운드 참여 취소
    public void cancelParticipateGround(long groundId, long userId){

        // user_ground테이블의 is_attending = 0
        // user의 예치금 다시 받기
        dao.cancelParticipateGround(groundId, userId);
        dao.receiveDeposit(groundId, userId);
    }
        // remain = 0으로, 돈 다시 회수
}
