package companion.challeculum.domains.user.userground;

import companion.challeculum.common.Constants;
import companion.challeculum.domains.ground.GroundDao;
import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.user.UserDao;
import companion.challeculum.domains.user.dtos.User;
import companion.challeculum.domains.user.dtos.UserInfoDto;
import companion.challeculum.domains.user.dtos.UserUpdateDto;
import companion.challeculum.domains.user.userground.dtos.Review;
import companion.challeculum.domains.user.userground.dtos.UserGround;
import companion.challeculum.domains.user.userground.dtos.UserGroundJoined;
import companion.challeculum.domains.user.userlecture.UserLectureDao;
import companion.challeculum.domains.user.userlecture.dtos.UserLecture;
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
        if (ground.getDeposit() > user.getPoint()) throw new RuntimeException(); // 에러 핸들링
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
        if (userGroundJoined == null) return true;
        return false;
    }

    @Override
    public List<UserInfoDto> getSuccessUserList(long groundId) {
        return userGroundDao.getUserGroundJoinedListByGroundId(groundId).stream()
                .filter(userGroundJoined -> userGroundJoined.getIsSuccess() != null)
                .filter(UserGroundJoined::getIsSuccess)
                .map(UserGroundJoined::toUserInfo).toList();
    }


    public boolean isReviewAvailable(long userId, long groundId) {
        if (userGroundDao.getUserGround(userId, groundId) == null) return false;
        return true;
    }

    public String getReward(long groundId) {
        int deposit = groundDao.getGroundByGroundId(groundId).getDeposit();
        List<UserGround> userGroundList = userGroundDao.getUserGroundListByGroundId(groundId);
        int totalNumber = userGroundList.size();
        int numOfSuccess = userGroundList.stream().filter(userGround -> userGround.getIsSuccess() == null || userGround.getIsSuccess()).toList().size();
        if (numOfSuccess == 0) throw new RuntimeException(); // 에러 핸들링
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
        if (reviewDao.getReviewByUserIdAndGroundId(userId,groundId) != null || !isReviewAvailable(userId, groundId)){
            throw new RuntimeException(); // 에러 핸들링
        }
        review.setUserId(userId);
        review.setGroundId(groundId);
        reviewDao.insert(review);
    }
}
