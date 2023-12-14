package cn.dsc.ufocus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库分组关系
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_grp_rel")
public class DbGroupRelEntity {

    /**
     * 数据库分组ID
     */
    @TableId(value = "db_grp_id", type = IdType.INPUT)
    private Long dbGroupId;

    /**
     * 数据库实例ID
     */
    @TableId(value = "db_inst_id", type = IdType.INPUT)
    private Long dbInstanceId;
}