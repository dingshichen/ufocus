package cn.dsc.ufocus.entity;

import cn.dsc.ufocus.entity.base.OperatorEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
    * 用户
    */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "usr")
public class UserEntity extends OperatorEntity {

    /**
     * 用户ID
     */
    @TableId(value = "usr_id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 中文名称
     */
    @TableField(value = "chn_nm")
    private String chnName;

    /**
     * 手机号码
     */
    @TableField(value = "mbl_phn_nmbr")
    private String mobilePhoneNumber;

    /**
     * 电子邮箱地址
     */
    @TableField(value = "email_adrs")
    private String emailAddress;

    /**
     * 是否锁定标志
     */
    @TableField(value = "is_lck_flg")
    private Boolean isLockFlag;

}