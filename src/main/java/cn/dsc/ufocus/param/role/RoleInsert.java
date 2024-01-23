package cn.dsc.ufocus.param.role;

import lombok.*;

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
public class RoleInsert {

    /**
     * 中文名称
     */
    @NotEmpty
    private String chnName;

    /**
     * 权限ID集合
     */
    @NotNull
    private List<Long> permissionIds;
}
