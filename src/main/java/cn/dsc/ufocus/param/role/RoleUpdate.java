package cn.dsc.ufocus.param.role;

import cn.dsc.ufocus.param.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author ding.shichen
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleUpdate extends Base {

    /**
     * 中文名称
     */
    @NotEmpty
    private String chnName;
}
