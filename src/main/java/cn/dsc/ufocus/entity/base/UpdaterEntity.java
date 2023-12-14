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
public abstract class UpdaterEntity {

    /**
     * 最近更新用户ID
     */
    @TableField(value = "latest_update_usr_id", fill = FieldFill.INSERT_UPDATE)
    private Long latestUpdateUserId;

    /**
     * 最近更新时间
     */
    @TableField(value = "latest_update_tm", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime latestUpdateTime;
}
