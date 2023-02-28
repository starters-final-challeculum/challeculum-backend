package companion.challeculum.domains.user.repositories;

import companion.challeculum.domains.user.dto.User;
import companion.challeculum.domains.user.dto.UserRegisterDto;
import companion.challeculum.domains.user.dto.UserUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * 메서드명 규칙 통일해주세요
     * join 은 허용하되 다른테이블을 직접 접근하지 않습니다. 해당 도메인에 해당하는 테이블에만 접근라도록 작성해주세요
     * 단일 컬럼은 가져오지 않습니다. Dao 를 통해 Entity 를 가져온 후 리턴 타입에 맞도록 서비스단에서 가공해주세요
     * insert(삽입) 쿼리의 경우 insert(...CreateDto dto) 혹은 insert(Entity entity) 형식으로 통일해주세요
     * <p>
     * update(변경) 쿼리의 경우 조회쿼리로 Entity 를 얻은 다음 toUpdateDto 를 사용해서 ...UpdateDto 를 획득한 후
     * Setter 를 통해 필요에 따라 적용하고자 하는 값을 적용 한 후 update(...UpdateDto dto) 형식으로 업데이트 하도록 통일합니다.
     * 혹은 update 할 수 있는 컬럼이 1개만 존재하는 경우(예를들어 user_ground 의 success 컬럼)  update(anyType columNameCamelCase)로 합니다.
     * toUpdateDto 메서드는 각 엔티티 클래스의 메서드입니다. 필요시 User 클래스를 참조하여 작성하세요
     * <p>
     * delete(삭제) 쿼리의 경우 delete(long entityId) 형식으로 통일합니다
     * <p>
     * select(조회)쿼리 작성시
     * where 절에 특정 조건을 줘야하는 경우 =>
     * GetEntityBy...(AnyType variable)로 작성해주세요
     * GetEntityListBy...(AnyType variable)로 작성해주세요
     * where 절에 조건을 추가할 수도 있지만, 자바 서비스단에서 stream 의 filter 를 적용하는 방법도 고려할 수 있습니다.
     */
    void registerUser(UserRegisterDto dto);

    void registerSocialLoginUser(User user);

    void updateUser(UserUpdateDto dto);

    void update(@Param("userId") long userId, @Param("updateMap") Map<String, Object> updateMap);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByOAuthId(String oauthId);

    void deleteUser(Long userId);

}
