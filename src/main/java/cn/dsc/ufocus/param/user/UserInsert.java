package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.InsertParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author ding.shichen
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInsert extends InsertParam {

    /**
     * 中文名称
     */
    @NotEmpty
    private String chnName;

    /**
     * 手机号码
     */
    private String mobilePhoneNumber;

    /**
     * 电子邮箱地址
     */
    @NotEmpty
    private String emailAddress;

    /**
     * 角色ID集合
     */
    @NotEmpty
    private List<Long> roleIds;

    /**
     * 密码
     */
    @NotEmpty
    private String pwd;
}
