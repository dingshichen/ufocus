package cn.dsc.ufocus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 角色
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role")
public class RoleEntity {

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

    /**
     * 创建用户ID
     */
    @TableField(value = "crt_usr_id")
    private Long createUserId;

    /**
     * 创建时间
     */
    @TableField(value = "crt_tm")
    private LocalDateTime createTime;

    /**
     * 最近更新用户ID
     */
    @TableField(value = "latest_update_usr_id")
    private Long latestUpdateUserId;

    /**
     * 最近更新时间
     */
    @TableField(value = "latest_update_tm")
    private LocalDateTime latestUpdateTime;
}