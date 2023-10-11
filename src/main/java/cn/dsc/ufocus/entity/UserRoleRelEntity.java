package cn.dsc.ufocus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "usr_role_rel")
public class UserRoleRelEntity {

    /**
     * 用户ID
     */
    @TableField(value = "usr_id")
    private Long userId;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;
}