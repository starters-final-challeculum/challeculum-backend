package companion.challeculum.domains.usermission;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/userMission")
@RequiredArgsConstructor
public class UserMissionController {

    private UserMissionService UserMissionService;


//    @PostMapping
//    public List<UserMissionDTO> insertUserMission(@RequestBody UserMissionDTO missionDTO) {
//        UserMissionService.createUserMission(missionDTO);
//        return UserMissionService.selectAllUserMission();
//    }

//    @GetMapping("/{id}")
//    public MissionDTO selectMissionById(@PathVariable Long id) {
//        return MissionService.selectMission(id);
//    }
//
//    @PutMapping("/{id}")
//    public List<MissionDTO> updateMission(@PathVariable Long id, @RequestBody MissionDTO missionDTO) {
//        MissionService.updateMission(id, missionDTO);
//        return MissionService.selectAllMissionInfo();
//    }
//
//    @DeleteMapping("/{id}")
//    public List<MissionDTO> deleteMission(@PathVariable Long id) {
//        MissionService.deleteMission(id);
//        return MissionService.selectAllMissionInfo();
//    }

}