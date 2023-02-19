package companion.challeculum.domains.user.dtos;

public record UserUpdateDto(Long id, String password, String nickname, String phone) {
}