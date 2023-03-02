package companion.challeculum.domains.user.repositories;

import companion.challeculum.domains.user.dto.Review;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReviewDao {
    void insert(Review review);

    List<Review> getReviewListByUserId(long userId);

    List<Review> getReviewListByGroundId(long groundId);

    List<Review> getAllReviewList(long userId);

    Review getReviewByUserIdAndGroundId(long userId, long groundId);
}