package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.OperatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 数据库工单
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_ticket")
public class DbTicketEntity extends OperatorEntity {

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

}