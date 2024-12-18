package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author ding.shichen
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdate extends Base {

    /**
     * 中文名称
     */
    @NotEmpty
    private String userName;

    /**
     * 手机号码
     */
    private String phoneNo;

    /**
     * 电子邮箱
     */
    @NotEmpty
    private String email;

    /**
     * 角色ID集合
     */
    @NotEmpty
    private List<Long> roleIds;
}
