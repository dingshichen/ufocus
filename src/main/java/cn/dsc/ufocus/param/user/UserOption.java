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
     * 用户姓名
     */
    private String userName;

    /**
     * 锁定标志
     */
    private Boolean lockFlag;

    public UserOption(Long id) {
        super(id);
    }
}
