package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.role.RoleOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ding.shichen
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserItem extends UserOption {

    /**
     * 手机号码
     */
    private String mobilePhoneNumber;

    /**
     * 电子邮箱地址
     */
    private String emailAddress;

    /**
     * 角色
     */
    private List<RoleOption> roles;

    /**
     * 创建用户
     */
    private UserOption createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最近更新用户
     */
    private UserOption latestUpdateUser;

    /**
     * 最近更新时间
     */
    private LocalDateTime latestUpdateTime;
}
