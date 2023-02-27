package companion.challeculum.domains.mission;

import companion.challeculum.domains.mission.dtos.Mission;
import companion.challeculum.domains.mission.dtos.MissionCreateDto;
import companion.challeculum.domains.mission.dtos.MissionJoined;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MissionDao {
    long insert(MissionCreateDto dto);
    void insertBatch(List<MissionCreateDto> missionList);
    void update(@Param("missionId") long missionId, @Param("updateMap") Map<String, Object>updateMap);
    void deleteMission(Long missionId);
    MissionJoined getMissionJoinedByMissionId(long missionId);
    List<Mission> getMissionList(long groundId);
    List<MissionJoined> getMissionJoinedList(long groundId);

}
