package cn.dsc.ufocus.param;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author ding.shichen
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operate {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;
}
