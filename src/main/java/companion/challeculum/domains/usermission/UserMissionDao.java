package companion.challeculum.domains.usermission;

import companion.challeculum.domains.usermission.dtos.UserMission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMissionDao {
    //// Jonghyun
    //// End of Jonghyun

    //// Kiyoung
    void insertUser(UserMission userMission);

    List<UserMission> getUserMissionByUserId(Long sessionId);
    //// End of Kiyoung

    //////Sojeong
    //////End of Sojeeong

    //////Hwajun
    //////End of Hwajun

    //////Hyunjoon
    //////End of Hyunjoon


}
