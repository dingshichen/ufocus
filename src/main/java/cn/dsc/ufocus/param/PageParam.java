package cn.dsc.ufocus.param;

import lombok.*;

import java.io.Serializable;

/**
 * @author ding.shichen
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageParam<Q extends Query> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 查询参数
     */
    private Q query;

    private long page = 1L;

    private long size = 10L;
}
