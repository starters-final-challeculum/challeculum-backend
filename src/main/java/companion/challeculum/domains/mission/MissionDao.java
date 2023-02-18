package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;
import companion.challeculum.domains.mission.dtos.MissionCreateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MissionDao {
    Mission selectMission(Long id);

    void addMissionsToGround(List<MissionCreateDto> missionList);

    List<Mission> selectAllMissionInfo();

    void registerMission(Mission mission);

    void updateMission(Mission mission);

    void deleteMission(Long id);
}