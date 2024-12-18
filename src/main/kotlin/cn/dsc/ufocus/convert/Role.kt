// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-11

package cn.dsc.ufocus.convert

import cn.dsc.ufocus.entity.RoleEntity
import cn.dsc.ufocus.param.role.Role
import cn.dsc.ufocus.param.role.RoleItem
import cn.dsc.ufocus.param.role.RoleOption
import cn.dsc.ufocus.param.user.UserOption

fun RoleEntity.toOption() = RoleOption().also {
    it.id = id
    it.chnName = chnName
}

fun RoleEntity.toItem() = RoleItem().also {
    it.id = id
    it.chnName = chnName
    it.createUser = UserOption(createUserId)
    it.createTime = createTime
}

fun RoleEntity.toDetail() = Role().also {
    it.id = id
    it.chnName = chnName
    it.createUser = UserOption(createUserId)
    it.createTime = createTime
    it.latestUpdateUser = UserOption(updateUserId)
    it.updateTime = updateTime
}