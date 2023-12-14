package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.OperatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 数据库工单迭代
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_ticket_scrm")
public class DbTicketScrumEntity extends OperatorEntity {

    /**
     * 数据库工单迭代ID
     */
    @TableId(value = "db_ticket_scrm_id", type = IdType.INPUT)
    private Long id;

    /**
     * 版本号
     */
    @TableField(value = "ver_num")
    private String versionNum;

    /**
     * 版本描述
     */
    @TableField(value = "ver_desc")
    private String versionDesc;

}