package companion.challeculum.domains.userground;

import companion.challeculum.domains.user.dtos.User;
import companion.challeculum.domains.user.dtos.UserInfoDto;
import companion.challeculum.domains.userground.dtos.Review;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;

import java.util.List;

public interface UserGroundService {
    void createUserGround(User user, long groundId);
    void deleteUserGround(User user, long groundId);
    void createReview(long userId, long groundId, Review review);
    List<UserGroundJoined> getMyGroundList(long userId, Integer page, String status);
    boolean isAvailableGround(long sessionId, long groundId);
    List<UserInfoDto> getSuccessUserList(long groundId);
    String getReward(long groundId);
    boolean isReviewAvailable(long userId,long groundId);
    List<UserInfoDto> getUserGroundList(long userId, long groundId);
    List<Review> getReviewList(long groundId);


}
