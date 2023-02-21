package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface MissionInfoService {
    void updateMission(Long id, Mission mission);

    Mission selectMission(Long id);

    List<Mission> selectAllMissionInfo();

    void insertMission(Mission mission);

    void deleteMission(Long id);
    List<Mission> getMyOngoingMissionList(Authentication authentication);

    String getMyMissionSuccessRate(Authentication authentication);

    List<Mission> getMissionListByGroupId(long GroundId);

}
