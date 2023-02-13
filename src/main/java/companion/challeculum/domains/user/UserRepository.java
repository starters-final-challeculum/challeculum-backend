package companion.challeculum.domains.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user
 */
@Mapper
@Repository
public interface UserRepository {
    Optional<User>  findById(long id);
    Optional<User>  findByUsername(String username);

    void registerUser(User user);
}
