package companion.challeculum.domains.ground.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class GroundLectureDto{
    private long id;
    private long lectureId;
    private String title;
    private String information;
    private int level;
    private int maxCapacity;
    private int deposit;
    private int isValidated;
    private int isPremium;
    private LocalDateTime createdAt;
    private LocalDate startAt;
    private LocalDate endAt;
    private LocalDateTime validatedAt;
    private String status;
    private int missionFailLimit;
    private long categoryId;
    private String platform;
    private String lectureTitle;
    private String instructor;
    private String url;
}
