package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.Query;
import lombok.*;

/**
 * @author ding.shichen
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery extends Query {

    private static final long serialVersionUID = 1L;

    /**
     * 中文名称
     */
    private String chnName;

    /**
     * 手机号码
     */
    private String mobilePhoneNumber;

    /**
     * 是否锁定标志
     */
    private Boolean isLockFlag;

    /**
     * 角色ID
     */
    private Long roleId;
}
