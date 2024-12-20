package cn.dsc.ufocus.dto

import cn.dsc.ufocus.base.RStatus

data class R<T>(
    val code: Int = RStatus.SUCCESS.code,
    val message: String = RStatus.SUCCESS.name,
    val data: T? = null
)

fun success() = R<Any>()

fun <T> success(apply: () -> T?) = R(data = apply())

fun RStatus.result() = R<Any>(this.code, this.message)

