package cn.dsc.ufocus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 许可
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "prmsn")
public class Permission {

    /**
     * 许可ID
     */
    @TableId(value = "prmsn_id", type = IdType.INPUT)
    private Long permissionId;

    /**
     * 许可名称
     */
    @TableField(value = "prmsn_nm")
    private String permissionName;

    /**
     * 许可编码
     */
    @TableField(value = "prmsn_cd")
    private String permissionCode;
}