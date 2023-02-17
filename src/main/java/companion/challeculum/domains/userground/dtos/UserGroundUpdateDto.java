package companion.challeculum.domains.userground.dtos;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.userground.dtos
 */
public record UserGroundUpdateDto(long id, int isAttending, int isSuccess, int rating, String comment) {
}
