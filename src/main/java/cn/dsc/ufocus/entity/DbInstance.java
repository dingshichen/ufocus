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
 * 数据库实例
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_inst")
public class DbInstance {

    /**
     * 数据库实例ID
     */
    @TableId(value = "db_inst_id", type = IdType.INPUT)
    private Long id;

    /**
     * 数据库实例名称
     */
    @TableField(value = "db_inst_nm")
    private String dbInstanceName;

    /**
     * 数据库产品代码
     */
    @TableField(value = "db_prdct_cd")
    private String dbProductCode;

    /**
     * 链接地址
     */
    @TableField(value = "lnk_drs")
    private String linkAddress;

    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 密码
     */
    @TableField(value = "pwd")
    private String pwd;

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