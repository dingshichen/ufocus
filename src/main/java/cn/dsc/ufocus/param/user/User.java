package cn.dsc.ufocus.param.user;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author ding.shichen
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends UserItem {

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
