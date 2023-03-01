package companion.challeculum.security.oauth.provider;

public interface OAuth2UserInfo {
    String getProviderId();

    String getProvider();

    String getEmail();

    String getNickname();

}
