package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.Base;
import lombok.*;

/**
 * @author ding.shichen
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOption extends Base {

    /**
     * 中文名称
     */
    private String chnName;

    /**
     * 是否锁定标志
     */
    private Boolean isLockFlag;

    public UserOption(Long id) {
        super(id);
    }
}
