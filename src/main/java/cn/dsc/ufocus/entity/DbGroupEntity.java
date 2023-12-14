package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.OperatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 数据库分组
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_grp")
public class DbGroupEntity extends OperatorEntity {

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

}