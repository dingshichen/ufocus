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
public class PageParam<Q extends Query> {

    /**
     * 查询参数
     */
    private Q query;

    private long page = 1L;

    private long size = 10L;
}
