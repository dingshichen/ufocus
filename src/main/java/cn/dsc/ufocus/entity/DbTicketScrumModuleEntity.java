package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.CreatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 数据库工单迭代模块
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_ticket_scrm_module")
public class DbTicketScrumModuleEntity extends CreatorEntity {

    /**
     * 数据库工单迭代模块ID
     */
    @TableId(value = "db_ticket_scrm_module_id", type = IdType.INPUT)
    private Long dbTicketScrumModuleId;

    /**
     * 数据库工单迭代模块类型
     */
    @TableField(value = "db_ticket_scrm_module_typ")
    private String dbTicketScrumModuleTyp;

    /**
     * 数据库工单迭代ID
     */
    @TableField(value = "db_ticket_scrm_id")
    private Long dbTicketScrumId;

    /**
     * 排序序号
     */
    @TableField(value = "sorting_seq_num")
    private Long sortingSeqNum;

}