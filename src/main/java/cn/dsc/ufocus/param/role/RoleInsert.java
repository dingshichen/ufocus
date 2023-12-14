package cn.dsc.ufocus.param.role;

import lombok.*;

import javax.validation.constraints.NotEmpty;

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
}
