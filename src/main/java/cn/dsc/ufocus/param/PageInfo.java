package cn.dsc.ufocus.param;

import lombok.*;

import java.util.List;

/**
 * @author ding.shichen
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> {

    /**
     * 数据列表
     */
    private List<T> records;

    /**
     * 总数
     */
    private long total;

    /**
     * 页容
     */
    private long size;

    /**
     * 页脚
     */
    private long current;
}
