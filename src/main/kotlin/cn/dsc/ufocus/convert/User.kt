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
    it.chnName = chnName
    it.isLockFlag = isLockFlag
}

fun UserEntity.toItem() = UserItem().also {
    it.id = id
    it.chnName = chnName
    it.isLockFlag = isLockFlag
    it.emailAddress = emailAddress
    it.mobilePhoneNumber = mobilePhoneNumber
}

fun UserEntity.toDetail() = User().also {
    it.id = id
    it.chnName = chnName
    it.isLockFlag = isLockFlag
    it.emailAddress = emailAddress
    it.mobilePhoneNumber = mobilePhoneNumber
    it.createUser = UserOption(createUserId)
    it.createTime = createTime
    it.latestUpdateUser = UserOption(latestUpdateUserId)
    it.latestUpdateTime = latestUpdateTime
}

