package cn.dsc.ufocus.param;

import lombok.*;

/**
 * @author ding.shichen
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelectQuery extends Query {

    /**
     * 关键字
     */
    private String keyword;
}
