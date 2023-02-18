package companion.challeculum.domains.user;

import companion.challeculum.domains.user.dtos.User;
import companion.challeculum.domains.user.dtos.UserRegisterDto;
import companion.challeculum.domains.user.dtos.UserUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user
 */
@Mapper
@Repository
public interface UserDao {
    void registerUser(UserRegisterDto dto);

    void registerSocialLoginUser(User user);

    void updateUser(UserUpdateDto dto);

    Optional<User> findById(long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByOAuthId(String oauthId);


}
