package cn.dsc.ufocus.param.role;

import cn.dsc.ufocus.param.Query;
import lombok.*;

/**
 * @author ding.shichen
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleQuery extends Query {

    /**
     * 角色名称
     */
    private String roleName;
}
