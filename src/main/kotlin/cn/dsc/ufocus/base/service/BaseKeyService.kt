// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-11

package cn.dsc.ufocus.base.service

import cn.dsc.ufocus.base.MustImplement
import cn.dsc.ufocus.exception.EntityNotFoundException
import cn.dsc.ufocus.param.IKeyBase
import cn.dsc.ufocus.param.PageInfo

interface BaseKeyService<K, Item : IKeyBase<K>> {

    @MustImplement
    fun listByKeys(keys: List<K>): List<Item>

    fun mapByKeys(keys: List<K>): Map<K, Item> {
        return listByKeys(keys).associateBy { it.key }
    }

    fun mapsByKeys(keys: List<K>): Map<K, List<Item>> {
        return listByKeys(keys).groupBy { it.key }
    }

    fun getByKey(key: K) = loadByKey(key) ?: throw EntityNotFoundException()

    fun loadByKey(key: K) = listByKeys(listOf(key)).firstOrNull()

    fun <Source> fillByKey(source: Source, getKey: (source: Source) -> K?, consumer: (source: Source, item: Item?) -> Unit) {
        fillByKey(listOf(source), getKey, consumer)
    }

    fun <Source> fillByKey(source: List<Source>, getKey: (source: Source) -> K?, consumer: (source: Source, item: Item?) -> Unit) {
        val map = listByKeys(source.mapNotNull(getKey)).associateBy { it.key }
        source.forEach {
            getKey(it)?.let { k ->
                consumer(it, map[k])
            }
        }
    }

    fun <Source> fillByKey(source: PageInfo<Source>, getKey: (source: Source) -> K?, consumer: (source: Source, item: Item?) -> Unit) {
        fillByKey(source.records, getKey, consumer)
    }

    fun <Source> fillByKeys(source: Source, getKeys: (source: Source) -> List<K>?, consumer: (source: Source, items: List<Item>) -> Unit) {
        fillByKeys(listOf(source), getKeys, consumer)
    }

    fun <Source> fillByKeys(source: List<Source>, getKeys: (source: Source) -> List<K>?, consumer: (source: Source, items: List<Item>) -> Unit) {
        val map = listByKeys(source.flatMap { getKeys(it) ?: emptyList() }).groupBy { it.key }
        source.forEach {
            getKeys(it)?.let { ks ->
                consumer(it, ks.mapNotNull { k -> map[k] }.flatten())
            }
        }
    }

    fun <Source> fillByKeys(source: PageInfo<Source>, getKeys: (source: Source) -> List<K>?, consumer: (source: Source, items: List<Item>) -> Unit) {
        fillByKeys(source.records, getKeys, consumer)
    }

    fun <Source> fillListByKey(source: Source, getKey: (source: Source) -> K?, consumer: (source: Source, items: List<Item>) -> Unit) {
        fillListByKey(listOf(source), getKey, consumer)
    }

    fun <Source> fillListByKey(source: List<Source>, getKey: (source: Source) -> K?, consumer: (source: Source, items: List<Item>) -> Unit) {
        val map = listByKeys(source.mapNotNull(getKey)).groupBy { it.key }
        source.forEach {
            getKey(it)?.let { k ->
                consumer(it, map[k] ?: emptyList())
            }
        }
    }

    fun <Source> fillListByKey(source: PageInfo<Source>, getKey: (source: Source) -> K?, consumer: (source: Source, items: List<Item>) -> Unit) {
        fillListByKey(source.records, getKey, consumer)
    }
}