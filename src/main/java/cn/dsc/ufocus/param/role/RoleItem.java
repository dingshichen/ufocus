package cn.dsc.ufocus.param.role;

import cn.dsc.ufocus.param.user.UserOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author ding.shichen
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleItem extends RoleOption {

    /**
     * 创建用户
     */
    private UserOption createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
