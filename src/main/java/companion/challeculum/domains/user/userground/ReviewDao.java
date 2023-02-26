package companion.challeculum.domains.user.userground;

import companion.challeculum.domains.user.userground.dtos.Review;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReviewDao {
    void insert(Review review);
    List<Review> getReviewListByUserId(long userId);
    List<Review> getReviewListByGroundId(long groundId);

    Review getReviewByUserIdAndGroundId(long userId, long groundId);
}