package companion.challeculum.domains.user;

public enum Role {

    ROLE_MEMBER("MEMBER"),
    ROLE_ADMIN("ADMIN");

    private final String key;

    Role(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


}
