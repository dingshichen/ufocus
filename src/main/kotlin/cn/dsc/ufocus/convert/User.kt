// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.convert

import cn.dsc.ufocus.entity.UserEntity
import cn.dsc.ufocus.param.user.User
import cn.dsc.ufocus.param.user.UserItem
import cn.dsc.ufocus.param.user.UserOption

fun UserEntity.toOption() = UserOption().also {
    it.id = id
    it.userName = userName
    it.lockFlag = lockFlag
}

fun UserEntity.toItem() = UserItem().also {
    it.id = id
    it.userName = userName
    it.lockFlag = lockFlag
    it.email = email
    it.phoneNo = phoneNo
}

fun UserEntity.toDetail() = User().also {
    it.id = id
    it.userName = userName
    it.lockFlag = lockFlag
    it.email = email
    it.phoneNo = phoneNo
    it.createUser = UserOption(createUserId)
    it.createTime = createTime
    it.latestUpdateUser = UserOption(updateUserId)
    it.updateTime = updateTime
}

