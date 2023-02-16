package companion.challeculum.domains.ground;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ListGroundDTO extends GroundDTO{
    int categoryId;

}
