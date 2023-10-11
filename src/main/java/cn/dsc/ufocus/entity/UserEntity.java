package cn.dsc.ufocus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    * 用户
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "usr")
public class UserEntity {

    /**
     * 用户ID
     */
    @TableId(value = "usr_id", type = IdType.ASSIGN_ID)
    private Long userId;

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

    /**
     * 创建用户ID
     */
    @TableField(value = "crt_usr_id")
    private Long createUserId;

    /**
     * 创建时间
     */
    @TableField(value = "crt_tm")
    private LocalDateTime createTime;

    /**
     * 最近更新用户ID
     */
    @TableField(value = "latest_update_usr_id")
    private Long latestUpdateUserId;

    /**
     * 最近更新时间
     */
    @TableField(value = "latest_update_tm")
    private LocalDateTime latestUpdateTime;
}