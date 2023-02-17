package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;

import java.util.List;

public interface MissionInfoService {
    void updateMission(Long id, Mission mission);

    Mission selectMission(Long id);

    List<Mission> selectAllMissionInfo();

    void insertMission(Mission mission);

    void deleteMission(Long id);
}
