// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-11

package cn.dsc.ufocus.convert

import cn.dsc.ufocus.param.PageInfo
import com.baomidou.mybatisplus.core.metadata.IPage

fun <E, R> IPage<E>.toPageInfo(trans: (source: E) -> R): PageInfo<R> {
    return PageInfo(this.records.map(trans), this.total, this.size, this.current)
}