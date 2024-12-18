package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.OperatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 角色
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role")
public class RoleEntity extends OperatorEntity {

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 角色名称
     */
    @TableField(value = "role_nm")
    private String roleName;

}