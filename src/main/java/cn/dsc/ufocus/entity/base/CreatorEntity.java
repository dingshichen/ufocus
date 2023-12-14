package cn.dsc.ufocus.entity.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author ding.shichen
 */
@Getter
@Setter
public abstract class CreatorEntity {

    /**
     * 创建用户ID
     */
    @TableField(value = "crt_usr_id", fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 创建时间
     */
    @TableField(value = "crt_tm", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
