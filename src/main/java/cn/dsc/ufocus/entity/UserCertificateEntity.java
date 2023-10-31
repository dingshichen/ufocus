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
 * 用户凭证
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "usr_crtfct")
public class UserCertificateEntity {

    /**
     * 用户ID
     */
    @TableId(value = "usr_id", type = IdType.INPUT)
    private Long userId;

    /**
     * 密码
     */
    @TableField(value = "pwd")
    private String pwd;

    /**
     * 记住我服务
     */
    @TableField(value = "rmbr_me_series")
    private String rememberMeSeries;

    /**
     * 记住我令牌
     */
    @TableField(value = "rmbr_me_tkn")
    private String rememberMeToken;

    /**
     * 记住我最近使用时间
     */
    @TableField(value = "rmbr_me_latest_used_tm")
    private LocalDateTime rememberMeLatestUsedTime;
}