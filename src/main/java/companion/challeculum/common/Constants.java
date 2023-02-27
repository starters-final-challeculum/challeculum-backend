package companion.challeculum.common;

import java.util.function.Function;

/**
 * Created by jonghyeon on 2023/02/14,
 * Package : companion.challeculum.common
 */
public class Constants {
    public static final String ROLE_MEMBER = "ROLE_MEMBER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final int ROWS_PER_PAGE = 10;
    public static final String GROUND_STANDBY = "GROUND_STANDBY";
    public static final String GROUND_ONGOING = "GROUND_ONGOING";
    public static final String GROUND_COMPLETED = "GROUND_COMPLETED";
    public static final String USER_MISSION_WAITING = "WAITING";
    public static final String USER_MISSION_REJECTED = "REJECTED";
    public static final String USER_MISSION_ACCEPTED = "ACCEPTED";
    public static final Function<String, String> TO_SNAKE_CASE = key -> key.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
}
