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
 * 用户密码
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "usr_pwd")
public class UserPasswordEntity {

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
}