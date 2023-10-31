// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.consts

/**
 * REST 接口响应状态码
 */
enum class RStatus(
    val code: Int,
    val message: String,
) {

    SUCCESS(0, "操作成功"),
    AUTH_FAIL(-1000, "认证无效"),
    PERMISSION_FAIL(-1100, "权限无效"),
    SYSTEM_ERROR(-2000, "系统异常"),
    LOGIN_FAIL(-2100, "登陆失败，账户名或密码错误"),
    LOGIN_LOCKED(-2101, "账户已被锁定")
}