package companion.challeculum.domains.mission;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MissionRepository {
    MissionDTO selectMission(Long id);

    List<MissionDTO> selectAllMissionInfo();

    void registerMission(MissionDTO missionDTO);

    void updateMission(MissionDTO missionDTO);

    void deleteMission(Long id);
}
