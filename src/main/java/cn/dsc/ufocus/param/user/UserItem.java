package cn.dsc.ufocus.param.user;

import lombok.*;

import java.time.LocalDateTime;

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
