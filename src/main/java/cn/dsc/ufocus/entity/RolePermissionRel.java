package cn.dsc.ufocus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class RolePermissionRel {
    /**
     * 许可ID
     */
    @TableId(value = "prmsn_id", type = IdType.INPUT)
    private Long permissionId;

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.INPUT)
    private Long roleId;
}