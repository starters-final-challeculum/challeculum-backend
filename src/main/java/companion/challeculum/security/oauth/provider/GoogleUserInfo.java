package companion.challeculum.security.oauth.provider;

import lombok.Builder;

import java.util.Map;

@Builder
public class GoogleUserInfo implements OAuth2UserInfo {
    private Map<String, Object> attributes; //oauth2user.getAttributes

    public GoogleUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getNickname() {
        return (String) attributes.get("name");
    }
}
