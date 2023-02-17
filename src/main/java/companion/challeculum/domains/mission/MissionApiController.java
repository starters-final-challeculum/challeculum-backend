package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mission")
@RequiredArgsConstructor
public class MissionApiController {
    private final MissionService MissionService;

    @PostMapping
    public List<Mission> insertMission(@RequestBody Mission mission) {
        MissionService.insertMission(mission);
        return MissionService.selectAllMissionInfo();
    }

    @GetMapping("/{id}")
    public Mission selectMissionById(@PathVariable Long id) {
        return MissionService.selectMission(id);
    }

    @PutMapping("/{id}")
    public List<Mission> updateMission(@PathVariable Long id, @RequestBody Mission mission) {
        MissionService.updateMission(id, mission);
        return MissionService.selectAllMissionInfo();
    }

    @DeleteMapping("/{id}")
    public List<Mission> deleteMission(@PathVariable Long id) {
        MissionService.deleteMission(id);
        return MissionService.selectAllMissionInfo();
    }


//    @DeleteMapping("/{missionId}")
//    public{
//
//    }

//    @GetMapping("/{missionId}")
//    public{
//
//    }
}
