// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-06

package cn.dsc.ufocus.base

/**
 * 标记必须实现的方法，用在基础接口上，方便开发阅读
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
annotation class MustImplement