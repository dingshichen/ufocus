package cn.dsc.ufocus.param.role;

import cn.dsc.ufocus.param.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ding.shichen
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleUpdate extends Base {

    /**
     * 角色名称
     */
    @NotEmpty
    private String roleName;

    /**
     * 权限ID集合
     */
    @NotNull
    private List<Long> permissionIds;
}
