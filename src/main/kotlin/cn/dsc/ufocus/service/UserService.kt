// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.service

import cn.dsc.ufocus.base.service.BaseFillService
import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.user.*
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService, BaseFillService<UserOption> {

    fun load(id: Long): User?

    fun page(param: PageParam<UserQuery>): PageInfo<UserItem>

    fun insert(userInsert: UserInsert): Long

    fun update(userUpdate: UserUpdate)

    fun lock(id: Long)

    fun unlock(id: Long)

}