package companion.challeculum.domains.usermission;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

@Mapper
public interface FileMapper {

    @Insert("INSERT INTO user_mission (user_id, mission_id,submit_at,is_accepted,image_url) VALUES (#{userId},#{missionId},#{submitAt},#{isAccepted}, #{imageUrl})")
    void insertFile(@Param("userId") int userId, @Param("missionId") int missionId, @Param("submitAt")LocalDate submitAt, @Param("isAccepted") String isAccepted, @Param("imageUrl") String imageUrl);
}


