// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.consts

import com.baomidou.mybatisplus.annotation.IEnum
import org.springframework.security.core.GrantedAuthority


// 这里要定义常量，用常量来关联到权限注解里的字面量
const val PRMS_USER_VIEW = "USER_VIEW"
const val PRMS_USER_MANAGE = "USER_MANAGE"
const val PRMS_ROLE_VIEW = "ROLE_VIEW"
const val PRMS_ROLE_MANAGE = "ROLE_MANAGE"

enum class PermissionCode(
    val code: String,
    val label: String,
) : IEnum<String>, GrantedAuthority {

    USER_VIEW(PRMS_USER_VIEW, "用户查看"),
    USER_MANAGE(PRMS_USER_MANAGE, "用户管理"),
    ROLE_VIEW(PRMS_ROLE_VIEW, "角色查看"),
    ROLE_MANAGE(PRMS_ROLE_MANAGE, "角色管理"),;

    override fun getValue(): String {
        return this.code
    }

    override fun getAuthority(): String {
        return this.name
    }
}