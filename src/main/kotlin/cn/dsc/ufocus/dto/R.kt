package cn.dsc.ufocus.dto

data class R<T>(
    val code: Int = 0,
    val message: String = "success",
    val data: T? = null
)

fun <T> result(apply: () -> T?) = R(data = apply())
