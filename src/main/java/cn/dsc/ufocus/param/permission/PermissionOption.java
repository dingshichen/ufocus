package cn.dsc.ufocus.param.permission;

import cn.dsc.ufocus.param.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ding.shichen
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionOption extends Base {

    /**
     * 许可名称
     */
    private String permissionName;
}
