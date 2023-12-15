// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-11-30

package cn.dsc.ufocus.base.service

import cn.dsc.ufocus.base.MustImplement
import cn.dsc.ufocus.exception.EntityNotFoundException
import cn.dsc.ufocus.param.IBase
import cn.dsc.ufocus.param.PageInfo

interface BaseFillService<Option : IBase> {

    @MustImplement
    fun listByIds(ids: List<Long>): List<Option>

    fun mapByIds(ids: List<Long>): Map<Long, Option> {
        return listByIds(ids).associateBy { it.id }
    }

    fun loadOptionById(id: Long): Option? = listByIds(listOf(id)).firstOrNull()

    fun getOptionById(id: Long): Option = loadOptionById(id)?: throw EntityNotFoundException()

    fun <E> fill(source: E, getOption: (source: E) -> Option?, consumer: (source: E, option: Option?) -> Unit) {
        fill(listOf(source), getOption, consumer)
    }

    fun <E> fill(source: List<E>, getOption: (source: E) -> Option?, consumer: (source: E, option: Option?) -> Unit) {
        fillById(source, { it: E -> getOption(it)?.id }, consumer)
    }

    fun <E> fill(source: PageInfo<E>, getOption: (source: E) -> Option?, consumer: (source: E, option: Option?) -> Unit) {
        fill(source.records, getOption, consumer)
    }

    fun <E> fillById(source: E, getId: (source: E) -> Long?, consumer: (source: E, option: Option?) -> Unit) {
        fillById(listOf(source), getId, consumer)
    }

    fun <E> fillById(source: List<E>, getId: (source: E) -> Long?, consumer: (source: E, option: Option?) -> Unit) {
        if (source.isEmpty()) {
            return
        }
        val map: Map<Long, Option> = mapByIds(source.mapNotNull(getId))
        source.forEach {
            getId(it)?.let { id -> consumer(it, map[id]) }
        }
    }

    fun <E> fillById(source: PageInfo<E>, getId: (source: E) -> Long?, consumer: (source: E, option: Option?) -> Unit) {
        fillById(source.records, getId, consumer)
    }

    fun <E> fillList(source: E, getList: (source: E) -> List<Option>?, consumer: (source: E, option: List<Option>) -> Unit) {
        fillList(listOf(source), getList, consumer)
    }

    fun <E> fillList(source: List<E>, getList: (source: E) -> List<Option>?, consumer: (source: E, option: List<Option>) -> Unit) {
        fillListById(source, { it: E -> getList(it)?.map { value -> value.id } }, consumer)
    }

    fun <E> fillList(source: PageInfo<E>, getList: (source: E) -> List<Option>?, consumer: (source: E, option: List<Option>) -> Unit) {
        fillList(source.records, getList, consumer)
    }

    fun <E> fillListById(source: E, getIds: (source: E) -> List<Long>?, consumer: (source: E, option: List<Option>) -> Unit) {
        fillListById(listOf(source), getIds, consumer)
    }

    fun <E> fillListById(source: List<E>, getIds: (source: E) -> List<Long>?, consumer: (source: E, option: List<Option>) -> Unit) {
        if (source.isEmpty()) {
            return
        }
        val itemWithIdMap: Map<E, List<Long>?> = source.associateWith(getIds)
        val idWithOptionMap: Map<Long, Option> = mapByIds(itemWithIdMap.values.filterNotNull().flatten())
        source.forEach {
            val ids = itemWithIdMap[it]
            if (ids == null) {
                consumer(it, emptyList())
            } else {
                val options: List<Option> = ids.mapNotNull { id -> idWithOptionMap[id] }
                consumer(it, options)
            }
        }
    }

    fun <E> fillListById(source: PageInfo<E>, getIds: (source: E) -> List<Long>?, consumer: (source: E, option: List<Option>) -> Unit) {
        fillListById(source.records, getIds, consumer)
    }

}