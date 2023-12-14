// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.consts

import com.baomidou.mybatisplus.annotation.IEnum
import org.springframework.security.core.GrantedAuthority

enum class PermissionCode(
    val label: String,
) : IEnum<String>, GrantedAuthority {

    USER_VIEW("用户查看"),
    USER_MANAGE("用户管理"),
    ROLE_VIEW("角色查看"),
    ROLE_MANAGE("角色管理"),;

    override fun getValue(): String {
        return this.name
    }

    override fun getAuthority(): String {
        return this.name
    }
}