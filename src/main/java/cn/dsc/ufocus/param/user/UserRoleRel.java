package cn.dsc.ufocus.param.user;

import cn.dsc.ufocus.param.IKeyBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ding.shichen
 */
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleRel implements IKeyBase<Long> {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    @Override
    public Long getKey() {
        return userId;
    }

    @Override
    public void setKey(Long key) {
        this.userId = key;
    }
}
