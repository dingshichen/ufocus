// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-11

package cn.dsc.ufocus.service

import cn.dsc.ufocus.base.service.BaseKeyService
import cn.dsc.ufocus.param.user.UserRoleRel

interface UserRoleRelService : BaseKeyService<Long, UserRoleRel> {

    fun listRoleIdsByUserId(userId: Long): List<Long>

    fun existByRoleId(roleId: Long): Boolean

    fun insert(userId: Long, roleIds: List<Long>)

    fun update(userId: Long, roleIds: List<Long>)

}