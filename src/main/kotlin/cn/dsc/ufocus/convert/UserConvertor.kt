// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.convert

import cn.dsc.ufocus.currentUser
import cn.dsc.ufocus.entity.UserEntity
import cn.dsc.ufocus.param.user.User
import cn.dsc.ufocus.param.user.UserInsert
import cn.dsc.ufocus.param.user.UserItem
import cn.dsc.ufocus.param.user.UserOption
import java.time.LocalDateTime

fun UserEntity.toDetail() = User().also {
    it.id = id
    it.chnName = chnName
    it.isLockFlag = isLockFlag
    it.emailAddress = emailAddress
    it.mobilePhoneNumber = mobilePhoneNumber
    it.createUser = UserOption(id)
    it.createTime = createTime
    it.latestUpdateUser = UserOption(id)
    it.latestUpdateTime = latestUpdateTime
}

fun UserEntity.toItem() = UserItem().also {
    it.id = id
    it.chnName = chnName
    it.isLockFlag = isLockFlag
    it.emailAddress = emailAddress
    it.mobilePhoneNumber = mobilePhoneNumber
    it.createUser = UserOption(id)
    it.createTime = createTime
    it.latestUpdateUser = UserOption(id)
    it.latestUpdateTime = latestUpdateTime
}

fun UserInsert.toEntity(): UserEntity {
    val currentUser = currentUser()
    val now = LocalDateTime.now()
    return UserEntity().also {
        it.chnName = chnName
        it.emailAddress = emailAddress
        it.mobilePhoneNumber = mobilePhoneNumber
        it.isLockFlag = false
        it.createUserId = currentUser.id
        it.createTime = now
        it.latestUpdateUserId = currentUser.id
        it.latestUpdateTime = now
    }
}