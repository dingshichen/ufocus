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
     * 用户姓名
     */
    @TableField(value = "usr_nm")
    private String userName;

    /**
     * 账号
     */
    @TableField(value = "acc_no")
    private String accountNo;

    /**
     * 手机号码
     */
    @TableField(value = "phn_no")
    private String phoneNo;

    /**
     * 电子邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 锁定标志
     */
    @TableField(value = "lck_flg")
    private Boolean lockFlag;

}