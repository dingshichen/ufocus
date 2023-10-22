package cn.dsc.ufocus.dto

import cn.dsc.ufocus.consts.RStatus

data class R<T>(
    val code: Int = RStatus.SUCCESS.code,
    val message: String = RStatus.SUCCESS.message,
    val data: T? = null
)

fun success() = R<Any>()

fun <T> success(apply: () -> T?) = R(data = apply())

fun fail(status: RStatus = RStatus.SYSTEM_ERROR) = R<Any>(status.code, status.message)

