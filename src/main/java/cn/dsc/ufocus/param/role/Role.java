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
public class Role extends RoleItem {

    /**
     * 最后更新人
     */
    private UserOption latestUpdateUser;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;
}
