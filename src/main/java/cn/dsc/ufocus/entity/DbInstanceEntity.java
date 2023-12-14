package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.OperatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库实例
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "db_inst")
public class DbInstanceEntity extends OperatorEntity {

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
}