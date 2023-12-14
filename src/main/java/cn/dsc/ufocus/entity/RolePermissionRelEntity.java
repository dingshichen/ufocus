package cn.dsc.ufocus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色许可关系
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role_prmsn_rel")
public class RolePermissionRelEntity {

    /**
     * 许可ID
     */
    @TableField(value = "prmsn_id")
    private Long permissionId;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    private Long roleId;
}