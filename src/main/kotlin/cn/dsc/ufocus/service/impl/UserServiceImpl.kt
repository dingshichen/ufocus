// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.convert.detail
import cn.dsc.ufocus.currentUser
import cn.dsc.ufocus.exception.EntityNotFoundException
import cn.dsc.ufocus.mapper.UserMapper
import cn.dsc.ufocus.param.user.User
import cn.dsc.ufocus.param.user.UserDetail
import cn.dsc.ufocus.service.RoleService
import cn.dsc.ufocus.service.UserCertificateService
import cn.dsc.ufocus.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class UserServiceImpl(
    val userMapper: UserMapper,
    val userCertificateService: UserCertificateService,
    val roleService: RoleService,
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

    @Transactional
    override fun lock(id: Long): Boolean {
        val user = userMapper.selectById(id) ?: throw EntityNotFoundException("用户不存在")
        user.isLockFlag = true
        user.latestUpdateUserId = currentUser().id
        user.latestUpdateTime = LocalDateTime.now()
        userMapper.updateById(user)
        return true
    }
}