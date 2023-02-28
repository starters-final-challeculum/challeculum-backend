package companion.challeculum.domains.mission;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.mission.dto.Mission;
import companion.challeculum.domains.mission.dto.MissionCreateDto;
import companion.challeculum.domains.mission.dto.MissionJoined;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mission")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;
    private final AuthUserManager authUserManager;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public void insertMission(@RequestBody MissionCreateDto missionCreateDto) {
        missionService.insertMission(missionCreateDto);
    }

    @PutMapping("/{missionId}")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public void updateMission(@PathVariable long missionId, @RequestBody Mission mission) {
        missionService.updateMission(missionId, mission);
    }

    @GetMapping("/detail/{missionId}")
    public MissionJoined getMission(@PathVariable long missionId) {
        return missionService.getMission(missionId);
    }

    @GetMapping("/{groundId}")
    List<Mission> getMissionList(@PathVariable long groundId) {
        return missionService.getMissionListByGroupId(groundId);
    }

    @GetMapping("/ongoing")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    List<MissionJoined> getMyOngoingMissionList(Authentication authentication) {
        return missionService.getMyOngoingMissionList(authUserManager.getSessionId(authentication));
    }

    @GetMapping("/success-rate")
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    String getMyMissionSuccessRate(Authentication authentication) {
        return missionService.getMyMissionSuccessRate(authUserManager.getSessionId(authentication));
    }
}

