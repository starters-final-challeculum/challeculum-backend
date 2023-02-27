package companion.challeculum.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by jonghyeon on 2023/02/26,
 * Package : companion.challeculum.common
 */
@Component
public class UpdateRecordUtil {
    public Map<String, Object> generateUpdateMap(Object updateDto, Function<String, String> fieldMapper, Function<Object, Object> valueMapper) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> updateMap = objectMapper.convertValue(updateDto, Map.class);
        return updateMap.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(
                        entry -> fieldMapper.apply(entry.getKey()),
                        entry -> valueMapper.apply(entry.getValue())
                ));
    }
}
