package companion.challeculum.domains.usermission;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class UserMissionDTO {
    @JsonProperty(value = "userId")
    private Long user_id;

    @JsonProperty(value = "missionId")
    private Long mission_id;

    @JsonProperty(value = "submitAt")
    private LocalDate submit_at;

    @JsonProperty(value = "isAccepted")
    private String is_accepted;

    @JsonProperty(value = "imageUrl")
    private String image_url;

    public UserMissionDTO(Long user_id, Long mission_id, LocalDate submit_at, String is_accepted, String image_url) {
        this.user_id = user_id;
        this.mission_id = mission_id;
        this.submit_at = submit_at;
        this.is_accepted = is_accepted;
        this.image_url = image_url;
    }
}
