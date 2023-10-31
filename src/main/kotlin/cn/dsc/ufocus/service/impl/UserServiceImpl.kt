// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.convert.detail
import cn.dsc.ufocus.mapper.UserMapper
import cn.dsc.ufocus.param.user.User
import cn.dsc.ufocus.param.user.UserDetail
import cn.dsc.ufocus.service.UserCertificateService
import cn.dsc.ufocus.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userMapper: UserMapper,
    val userCertificateService: UserCertificateService
) : UserService {

    override fun loadUserByUsername(username: String): UserDetails {
        val entity = userMapper.selectByEmail(username) ?: throw UsernameNotFoundException("获取不到用户")
        val password = userCertificateService.loadPassword(entity.id)
        return UserDetail(entity.id, entity.emailAddress, password, entity.isLockFlag)
    }

    override fun load(id: Long): User? {
        val user = userMapper.selectById(id)?.detail() ?: return null
        // TODO FILL

        return user
    }
}