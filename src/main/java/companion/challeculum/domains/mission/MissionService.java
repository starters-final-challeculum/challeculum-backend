package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MissionService implements MissionInfoService {
    @Autowired
    private MissionRepository MissionRepository;

    @Override
    public void updateMission(Long id, Mission missionDTO) {
        Mission mission = MissionRepository.selectMission(id);
        if (mission != null) {
            mission.setGroundId(missionDTO.getGroundId());
            mission.setAssignment(missionDTO.getAssignment());
            mission.setStartAt(missionDTO.getStartAt());
            mission.setEndAt(missionDTO.getEndAt());
            MissionRepository.updateMission(mission);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }
    }

    public Mission selectMission(Long id) {
        return MissionRepository.selectMission(id);
    }

    public List<Mission> selectAllMissionInfo() {
        return MissionRepository.selectAllMissionInfo();
    }

    public void insertMission(Mission mission) {
        MissionRepository.registerMission(mission);
    }

    public void deleteMission(Long id) {
        if (MissionRepository.selectMission(id) != null) {
            MissionRepository.deleteMission(id);
        } else {
            throw new IllegalStateException("미션이 존재하지 않습니다.");
        }
    }

}
