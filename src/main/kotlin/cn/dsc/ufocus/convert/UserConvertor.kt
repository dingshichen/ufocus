// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.convert

import cn.dsc.ufocus.entity.UserEntity
import cn.dsc.ufocus.param.user.User
import cn.dsc.ufocus.param.user.UserOption

fun UserEntity.detail() = User().also {
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