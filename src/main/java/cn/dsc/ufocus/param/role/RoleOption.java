package cn.dsc.ufocus.param.role;

import cn.dsc.ufocus.param.Base;
import lombok.*;

/**
 * @author ding.shichen
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleOption extends Base {

    /**
     * 角色名称
     */
    private String roleName;
}
