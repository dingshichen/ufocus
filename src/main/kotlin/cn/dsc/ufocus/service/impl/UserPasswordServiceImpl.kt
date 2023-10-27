// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.mapper.UserPasswordMapper
import cn.dsc.ufocus.param.user.UserDetail
import cn.dsc.ufocus.service.UserPasswordService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class UserPasswordServiceImpl(
    val userPasswordMapper: UserPasswordMapper
) : UserPasswordService {

    override fun loadPassword(userId: Long): String {
        return userPasswordMapper.selectPassword(userId)
    }

    override fun updatePassword(user: UserDetails, newPassword: String): UserDetails {
        userPasswordMapper.updatePassword((user as UserDetail).id, newPassword)
        user.password = newPassword
        return user
    }
}