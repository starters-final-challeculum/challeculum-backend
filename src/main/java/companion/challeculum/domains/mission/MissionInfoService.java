package companion.challeculum.domains.mission;

import java.util.List;

public interface MissionInfoService {
    void updateMission(Long id, MissionDTO missionDTO);

    MissionDTO selectMission(Long id);

    List<MissionDTO> selectAllMissionInfo();

    void insertMission(MissionDTO missionDTO);

    void deleteMission(Long id);
}
