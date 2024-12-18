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
     * 用户姓名
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phoneNo;

    /**
     * 锁定标志
     */
    private Boolean lockFlag;

    /**
     * 角色ID
     */
    private Long roleId;
}
