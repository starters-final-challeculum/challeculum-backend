package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GroundDao {

    /**
     * 메서드명 규칙 통일해주세요
     * join 은 허용하되 다른테이블을 직접 접근하지 않습니다. 해당 도메인에 해당하는 테이블에만 접근라도록 작성해주세요
     * 단일 컬럼은 가져오지 않습니다. Dao 를 통해 Entity, ...Joined 를 가져온 후 리턴 타입에 맞도록 서비스단에서 가공해주세요
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
     * getEntityBy...(AnyType variable)로 작성해주세요
     * getEntityListBy...(AnyType variable)로 작성해주세요
     * where 절에 조건을 추가할 수도 있지만, 자바 서비스단에서 stream 의 filter 를 적용하는 방법도 고려할 수 있습니다.
     */

    // 기본 메서드
    long insert(GroundCreateDto dto);
    Ground getGroundByGroundId(long groundId);
    GroundJoined getGroundJoinedByGroundId(long groundId);

//   Ki Young
    Ground getDepositById(long groundId);
// End of Ki Young
    void deleteGround(long groundId);

    List<GroundJoined> getGroundList(@Param("startRow") Integer startRow,
                                     @Param("limit") int limit,
                                     @Param("filterMap") Map<String, String> filterMap,
                                     @Param("sortBy") String sortBy,
                                     @Param("orderBy") String orderBy,
                                     @Param("keyword") String keyword);

    List<Map<String, Object>> getGroundsByMe(long userId);

    List<Map<String,Object>> getMyGroundList(@Param("userId") long userId,
                                               @Param("startRow") Integer startRow,
                                               @Param("ROWS_PER_PAGE") int rowsPerPage,
                                               @Param("status") String status);

    void refundDeposit(long groundId);

    void markNotAttending(long groundId);

    int updateGround(@Param("groundId") long groundId, @Param("updateMap") Map<String,Object> updateMap);

    Long getGroundCreator(long groundId);

    List<Map<String, Object>> getMyGrounds(long userId);

    long getLastInsertId();
}
