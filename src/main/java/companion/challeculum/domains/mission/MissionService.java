package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;
import companion.challeculum.domains.mission.dtos.MissionCreateDto;
import companion.challeculum.domains.mission.dtos.MissionJoined;

import java.util.List;

public interface MissionService {
    void updateMission(long missionId, Mission mission);
    MissionJoined getMission(long id);
    void insertMission(MissionCreateDto mission);
    List<MissionJoined> getMyOngoingMissionList(long userId);
    String getMyMissionSuccessRate(long userId);
    List<Mission> getMissionListByGroupId(long GroundId);
}
