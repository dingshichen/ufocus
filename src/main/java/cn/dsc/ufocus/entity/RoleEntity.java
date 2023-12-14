package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.OperatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色
 */
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
     * 中文名称
     */
    @TableField(value = "chn_nm")
    private String chnName;

}