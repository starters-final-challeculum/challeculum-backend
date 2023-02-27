package companion.challeculum.domains.ground.dtos;

import lombok.Data;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Ground {
    private long groundId;
    private long createUserId;
    private long lectureId;
    private String groundTitle;
    private String information;
    private int minCapacity;
    private int deposit;
    private LocalDateTime createdAt;
    private LocalDate startAt;
    private LocalDate endAt;
    private String status;

    public GroundUpdateDto toUpdateDto(){
        GroundUpdateDto groundUpdateDto = new GroundUpdateDto(groundId, createUserId, lectureId, groundTitle, information, minCapacity, deposit, startAt, endAt, status);
        return groundUpdateDto;
    }
}
