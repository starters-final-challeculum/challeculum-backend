package companion.challeculum.domains.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mission")
@RequiredArgsConstructor
public class MissionApiController {
    @Autowired
    private MissionService MissionService;

    @PostMapping
    public List<MissionDTO> insertMission(@RequestBody MissionDTO missionDTO) {
        MissionService.insertMission(missionDTO);
        return MissionService.selectAllMissionInfo();
    }

    @GetMapping("/{id}")
    public MissionDTO selectMissionById(@PathVariable Long id) {
        return MissionService.selectMission(id);
    }

    @PutMapping("/{id}")
    public List<MissionDTO> updateMission(@PathVariable Long id, @RequestBody MissionDTO missionDTO) {
        MissionService.updateMission(id, missionDTO);
        return MissionService.selectAllMissionInfo();
    }

    @DeleteMapping("/{id}")
    public List<MissionDTO> deleteMission(@PathVariable Long id) {
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
