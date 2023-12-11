package cn.dsc.ufocus.param.role;

import cn.dsc.ufocus.param.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ding.shichen
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleOption extends Base {

    /**
     * 中文名称
     */
    private String chnName;
}
