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
 * 数据库分组
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_grp")
public class DbGroup {

    /**
     * 数据库分组ID
     */
    @TableId(value = "db_grp_id", type = IdType.INPUT)
    private Long id;

    /**
     * 分组名称
     */
    @TableField(value = "grp_nm")
    private String groupName;

    /**
     * 分组描述
     */
    @TableField(value = "grp_desc")
    private String groupDesc;

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