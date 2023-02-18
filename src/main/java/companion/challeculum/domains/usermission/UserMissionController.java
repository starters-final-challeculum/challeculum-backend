package companion.challeculum.domains.usermission;

import companion.challeculum.domains.mission.dtos.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userMission")
@RequiredArgsConstructor
public class UserMissionController {

    private UserMissionService UserMissionService;

    @PostMapping("/api/v1/usermission/{missionId}")
    void createUserMission(Authentication authentication,
                      @PathVariable long missionId,
                      MultipartFile multipartFile){

    }
    @GetMapping("/api/v1/usermission/successrate")
    double getMyMissionSuccessRate(Authentication authentication){
        return 0.0;
    }
    @GetMapping("/api/v1/usermission")
    List<Mission> getMyOngoingMissionList(Authentication authentication){
        return null;
    }

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