// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.service

import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.user.User
import cn.dsc.ufocus.param.user.UserInsert
import cn.dsc.ufocus.param.user.UserItem
import cn.dsc.ufocus.param.user.UserQuery
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService {

    fun load(id: Long): User?

    fun lock(id: Long): Boolean

    fun list(param: PageParam<UserQuery>): PageInfo<UserItem>

    fun insert(userInsert: UserInsert): Long
}