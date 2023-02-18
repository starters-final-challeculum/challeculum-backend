package companion.challeculum.domains.user.dtos;

public record UserUpdateDto(long id, String password, String nickname, String phone) {
}