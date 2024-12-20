package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.role.RoleOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private String phoneNo;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 角色
     */
    private List<RoleOption> roles;

}
