package companion.challeculum.security.oauth.provider;

import lombok.Builder;

import java.util.Map;

@Builder
public class NaverUserInfo implements OAuth2UserInfo {
    private Map<String, Object> attributes; //oauth2user.getAttributes

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getNickname() {
        return (String) attributes.get("nickname");
    }
}
