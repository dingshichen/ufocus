package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.UpdaterEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 数据库工单脚本
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_ticket_script")
public class DbTicketScriptEntity extends UpdaterEntity {

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

}