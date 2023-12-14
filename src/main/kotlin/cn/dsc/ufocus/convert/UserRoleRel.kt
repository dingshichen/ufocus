// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-11

package cn.dsc.ufocus.convert

import cn.dsc.ufocus.entity.UserRoleRelEntity
import cn.dsc.ufocus.param.role.RoleOption
import cn.dsc.ufocus.param.user.UserRoleRel

fun UserRoleRelEntity.toDetail() = UserRoleRel().also {
    it.userId = userId
    it.roleId = roleId
}

fun UserRoleRel.toRole() = RoleOption().also {
    it.id = roleId
}