package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.CreatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 数据库工单脚本异常日志
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_ticket_script_xcptn_log")
public class DbTicketScriptExceptionLogEntity extends CreatorEntity {

    /**
     * 日志ID
     */
    @TableId(value = "log_id", type = IdType.INPUT)
    private Long id;

    /**
     * 数据库工单脚本ID
     */
    @TableField(value = "db_ticket_script_id")
    private Long dbTicketScriptId;

    /**
     * 执行脚本文本内容
     */
    @TableField(value = "prfm_script_text_cntnt")
    private String performScriptTextContent;

    /**
     * 执行异常信息内容
     */
    @TableField(value = "prfm_xcptn_info_cntnt")
    private String performExceptionInfoContent;

}