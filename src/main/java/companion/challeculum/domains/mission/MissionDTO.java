package companion.challeculum.domains.mission;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class MissionDTO {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "ground_id")
    private Long ground_id;
    @JsonProperty(value = "assignment")
    private String assignment;
    @JsonProperty(value = "startAt")
    private LocalDate startAt;
    @JsonProperty(value = "endAt")
    private LocalDate endAt;


    public MissionDTO(Long id, Long ground_id, String assignment, LocalDate startAt, LocalDate endAt) {
        this.id = id;
        this.ground_id = ground_id;
        this.assignment = assignment;
        this.startAt = startAt;
        this.endAt = endAt;
    }

//    public static class UpdateDto {
//        public static class UpdateDtoBuilder{
//            private final
//        }
//    }
}
