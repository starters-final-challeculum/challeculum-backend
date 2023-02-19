package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mission")
@RequiredArgsConstructor
public class MissionApiController {
    private final MissionService missionService;

    @PostMapping
    public List<Mission> insertMission(@RequestBody Mission mission) {
        missionService.insertMission(mission);
        return missionService.selectAllMissionInfo();
    }
    @GetMapping("/{id}")
    public Mission selectMissionById(@PathVariable Long id) {
        return missionService.selectMission(id);
    }

    @PutMapping("/{id}")
    public List<Mission> updateMission(@PathVariable Long id, @RequestBody Mission mission) {
        missionService.updateMission(id, mission);
        return missionService.selectAllMissionInfo();
    }

    @DeleteMapping("/{id}")
    public List<Mission> deleteMission(@PathVariable Long id) {
        missionService.deleteMission(id);
        return missionService.selectAllMissionInfo();
    }

    @GetMapping("/ongoing")
    List<Mission> getMyOngoingMissionList(Authentication authentication) {
        return missionService.getMyOngoingMissionList(authentication);
    }

    @GetMapping("/successrate")
    String getMyMissionSuccessRate(Authentication authentication){
        return missionService.getMyMissionSuccessRate(authentication);
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
