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
 * 数据库工单
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_ticket")
public class DbTicket {

    /**
     * 工单ID
     */
    @TableId(value = "ticket_id", type = IdType.INPUT)
    private Long id;

    /**
     * 数据库分组ID
     */
    @TableField(value = "db_grp_id")
    private Long dbGroupId;

    /**
     * 数据库工单迭代ID
     */
    @TableField(value = "db_ticket_scrm_id")
    private Long dbTicketScrumId;

    /**
     * 数据库工单迭代模块ID
     */
    @TableField(value = "db_ticket_scrm_module_id")
    private Long dbTicketScrumModuleId;

    /**
     * 工单名称
     */
    @TableField(value = "ticket_nm")
    private String ticketName;

    /**
     * 紧前数据库工单ID
     */
    @TableField(value = "bfr_db_ticket_id")
    private Long beforeDbTicketId;

    /**
     * 审核状态
     */
    @TableField(value = "adt_state")
    private String auditState;

    /**
     * 执行状态
     */
    @TableField(value = "prfm_state")
    private String performState;

    /**
     * 文本内容
     */
    @TableField(value = "text_cntnt")
    private String textContent;

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