package companion.challeculum.domains.ground;

public interface GroundService {
    void deleteGround(long groundId);

    GroundDTO showGroundDetail(long groundId);
}
