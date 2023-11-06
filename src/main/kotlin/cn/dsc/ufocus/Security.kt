// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-11-06

package cn.dsc.ufocus

import cn.dsc.ufocus.exception.CurrentUserNotFoundException
import cn.dsc.ufocus.param.user.UserDetail
import org.springframework.security.core.context.SecurityContextHolder

fun currentUser() = (possiblePrincipal() ?: throw CurrentUserNotFoundException("当前操作用户不存在")) as UserDetail

fun possiblePrincipal() = SecurityContextHolder.getContext().authentication?.principal