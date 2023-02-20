package companion.challeculum.domains.usermission;

import companion.challeculum.domains.usermission.dtos.UserMission;
import org.mybatis.spring.SqlSessionTemplate;

public class DBService {
    private SqlSessionTemplate sqlSessionTemplate;

    public DBService(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public void insertFile(UserMission fileDTO) {
        sqlSessionTemplate.insert("insertFile", fileDTO);
    }
}
