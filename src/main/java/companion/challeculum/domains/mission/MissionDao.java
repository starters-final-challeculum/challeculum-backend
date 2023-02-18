package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MissionDao {
    Mission selectMission(Long id);

    List<Mission> selectAllMissionInfo();

    void registerMission(Mission mission);

    void updateMission(Mission mission);

    void deleteMission(Long id);
}
