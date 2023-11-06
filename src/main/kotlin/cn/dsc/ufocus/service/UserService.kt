// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.service

import cn.dsc.ufocus.param.user.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {

    fun load(id: Long): User?

    fun lock(id: Long): Boolean
}