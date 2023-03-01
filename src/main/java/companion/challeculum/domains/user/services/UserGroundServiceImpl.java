package companion.challeculum.domains.user.services;

import companion.challeculum.common.Constants;
import companion.challeculum.common.exceptions.intented.CannotReviewOnGroundException;
import companion.challeculum.common.exceptions.intented.NoSuccessUserInGroundException;
import companion.challeculum.common.exceptions.intented.UserPointDeficiencyException;
import companion.challeculum.domains.ground.GroundDao;
import companion.challeculum.domains.ground.dto.Ground;
import companion.challeculum.domains.user.dto.*;
import companion.challeculum.domains.user.repositories.ReviewDao;
import companion.challeculum.domains.user.repositories.UserDao;
import companion.challeculum.domains.user.repositories.UserGroundDao;
import companion.challeculum.domains.user.repositories.UserLectureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserGroundServiceImpl implements UserGroundService {
    private final UserGroundDao userGroundDao;
    private final ReviewDao reviewDao;
    private final UserLectureDao userLectureDao;
    private final GroundDao groundDao;
    private final UserDao userDao;

    @Override
    public void createUserGround(User user, long groundId) {
        Ground ground = groundDao.getGroundByGroundId(groundId);
        UserLecture userLecture = userLectureDao.findUserLecture(user.getUserId(), ground.getLectureId());
        if (userLecture == null) throw new RuntimeException();
        if (ground.getDeposit() > user.getPoint()) throw new UserPointDeficiencyException("그라운드에 참여하기 위한 포인트가 부족합니다");
        userGroundDao.insert(user.getUserId(), groundId);
        user.setPoint(user.getPoint() - ground.getDeposit());
        userDao.updateUser(user.toUpdateDto());
    }

    @Override
    public void deleteUserGround(User user, long groundId) {
        UserUpdateDto userUpdateDto = user.toUpdateDto();
        Ground ground = groundDao.getGroundByGroundId(groundId);
        userUpdateDto.setPoint(ground.getDeposit());
        userDao.updateUser(userUpdateDto);
        userGroundDao.delete(user.getUserId(), groundId);
    }

    @Override
    public List<UserGroundJoined> getMyGroundList(long userId, Integer page, String status) {
        int limit = Constants.ROWS_PER_PAGE;
        int offset = Constants.ROWS_PER_PAGE * (page - 1);
        return userGroundDao.getUserGroundJoinedListByUserIdAndStatus(userId, status, limit, offset);
    }

    @Override
    public boolean isAvailableGround(long sessionId, long groundId) {
        UserGroundJoined userGroundJoined = userGroundDao.getUserGroundJoined(sessionId, groundId);
        return userGroundJoined == null;
    }

    @Override
    public List<UserInfoDto> getSuccessUserList(long groundId) {
        return userGroundDao.getUserGroundJoinedListByGroundId(groundId).stream()
                .filter(userGroundJoined -> userGroundJoined.getIsSuccess() != null)
                .filter(UserGroundJoined::getIsSuccess)
                .map(UserGroundJoined::toUserInfo).toList();
    }


    public boolean isReviewAvailable(long userId, long groundId) {
        return userGroundDao.getUserGround(userId, groundId) != null;
    }

    public String getReward(long groundId) {
        int deposit = groundDao.getGroundByGroundId(groundId).getDeposit();
        List<UserGround> userGroundList = userGroundDao.getUserGroundListByGroundId(groundId);
        int totalNumber = userGroundList.size();
        int numOfSuccess = userGroundList.stream().filter(userGround -> userGround.getIsSuccess() == null || userGround.getIsSuccess()).toList().size();
        if (numOfSuccess == 0) throw new NoSuccessUserInGroundException("그라운드에 성공한 유저가 존재하지 않으므로 보상금을 계산할 수 없습니다.");
        return String.valueOf((int) Math.floor(((deposit * totalNumber) / numOfSuccess) / 10) * 10);
    }

    @Override
    public List<UserInfoDto> getUserGroundList(long groundId) {
        return userGroundDao.getUserGroundJoinedListByGroundId(groundId).stream().map(UserGroundJoined::toUserInfo).toList();
    }

    @Override
    public List<Review> getReviewList(long groundId) {
        return reviewDao.getReviewListByGroundId(groundId);
    }

    @Override
    public void createReview(long userId, long groundId, Review review) {
        if (reviewDao.getReviewByUserIdAndGroundId(userId, groundId) != null || !isReviewAvailable(userId, groundId)) {
            throw new CannotReviewOnGroundException("그라운드에 참여한 유저만 리뷰를 남길 수 있습니다");
        }
        review.setUserId(userId);
        review.setGroundId(groundId);
        reviewDao.insert(review);
    }
}
