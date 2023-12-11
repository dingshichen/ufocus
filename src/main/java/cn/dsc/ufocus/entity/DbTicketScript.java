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
 * 数据库工单脚本
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_ticket_script")
public class DbTicketScript {

    /**
     * 数据库工单脚本ID
     */
    @TableId(value = "db_ticket_script_id", type = IdType.INPUT)
    private Long id;

    /**
     * 数据库工单ID
     */
    @TableField(value = "ticket_id")
    private Long ticketId;

    /**
     * 文本内容
     */
    @TableField(value = "text_cntnt")
    private String textContent;

    /**
     * 执行状态
     */
    @TableField(value = "prfm_state")
    private String performState;

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