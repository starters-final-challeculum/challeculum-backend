package companion.challeculum.domains.userground;

import companion.challeculum.domains.userground.dtos.Review;
import companion.challeculum.domains.userground.dtos.UserGround;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserGroundDao {
    /**
     * 메서드명 규칙 통일해주세요
     * join 은 허용하되 다른테이블을 직접 접근하지 않습니다. 해당 도메인에 해당하는 테이블에만 접근라도록 작성해주세요
     * 단일 컬럼은 가져오지 않습니다. Dao 를 통해 Entity 를 가져온 후 리턴 타입에 맞도록 서비스단에서 가공해주세요
     * insert(삽입) 쿼리의 경우 insert(...CreateDto dto) 혹은 insert(Entity entity) 형식으로 통일해주세요
     *
     * update(변경) 쿼리의 경우 조회쿼리로 Entity 를 얻은 다음 toUpdateDto 를 사용해서 ...UpdateDto 를 획득한 후
     * Setter 를 통해 필요에 따라 적용하고자 하는 값을 적용 한 후 update(...UpdateDto dto) 형식으로 업데이트 하도록 통일합니다.
     * 혹은 update 할 수 있는 컬럼이 1개만 존재하는 경우(예를들어 user_ground 의 success 컬럼)  update(anyType columNameCamelCase)로 합니다.
     * toUpdateDto 메서드는 각 엔티티 클래스의 메서드입니다. 필요시 User 클래스를 참조하여 작성하세요
     *
     * delete(삭제) 쿼리의 경우 delete(long entityId) 형식으로 통일합니다
     *
     * select(조회)쿼리 작성시
     * where 절에 특정 조건을 줘야하는 경우 =>
     * GetEntityBy...(AnyType variable)로 작성해주세요
     * GetEntityListBy...(AnyType variable)로 작성해주세요
     * where 절에 조건을 추가할 수도 있지만, 자바 서비스단에서 stream 의 filter 를 적용하는 방법도 고려할 수 있습니다.
     */

    /////////// JongHyun
    UserGround getUserGround(long userId, long groundId);
    UserGroundJoined getUserGroundJoined(long userId, long groundId);
    List<UserGround> getUserGroundListByGroundId(long groundId);
    List<UserGroundJoined> getUserGroundJoinedListByGroundId(long groundId);
    List<UserGround> getUserGroundListByUserId(long userId);
    List<UserGroundJoined> getUserGroundJoinedListByUserId(long userId);
    ////////// End of JongHyun

    /////////// Kiyoung
    int getUserGroundCountByGroundId(long groundId);
    int getUserGroundSuccessCountByGroundId(long groundId);

    Integer isReviewAvailable(long groundId, long userId);

    /////////// End of Kiyoung

    /////////// Sojeong
    /////////// End of Sojeong

    /////////// Hwajun
    List<UserGroundJoined> getUserGroundList(long userId, long groundId);

    int reviewUserGround(long userId, long groundId, Review review);
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
    int getOnDoingLecture(long lectureId, long userId);

    //처음 신청하는 것인지 확인
    int checkFirstParticipant(long groundId, long userId);

    //그라운드 참여 취소
    void changeUserGround(long groundId, long userId);

    //예치금 다시 받기
    void receiveDeposit(long groundId, long userId);
    //////////// End of Hyunjoon

//    Redesign (2/25)
    void insert(long userId, long groundId);
}