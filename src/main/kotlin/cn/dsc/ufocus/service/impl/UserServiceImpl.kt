// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.convert.*
import cn.dsc.ufocus.currentUser
import cn.dsc.ufocus.entity.UserEntity
import cn.dsc.ufocus.exception.EntityNotFoundException
import cn.dsc.ufocus.mapper.UserMapper
import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.user.*
import cn.dsc.ufocus.service.RoleService
import cn.dsc.ufocus.service.UserCertificateService
import cn.dsc.ufocus.service.UserRoleRelService
import cn.dsc.ufocus.service.UserService
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO
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
    val userRoleRelService: UserRoleRelService,
) : UserService {

    override fun loadUserByUsername(username: String): UserDetails {
        val entity = userMapper.selectByEmail(username) ?: throw UsernameNotFoundException("获取不到用户")
        val password = userCertificateService.loadPassword(entity.id)
        return UserDetail(entity.id, entity.emailAddress, password, entity.isLockFlag)
    }

    override fun load(id: Long): User? {
        val user = userMapper.selectById(id)?.toDetail() ?: return null
        userRoleRelService.fillListByKey(user, UserItem::getId) { u, r ->
            u.roles = r.map(UserRoleRel::toRole)
        }
        roleService.fillList(user, UserItem::getRoles) { u, r ->
            u.roles = r
        }
        return user
    }

    @Transactional
    override fun lock(id: Long) {
        val user = userMapper.selectById(id) ?: throw EntityNotFoundException("用户不存在")
        user.isLockFlag = true
        user.latestUpdateUserId = currentUser().id
        user.latestUpdateTime = LocalDateTime.now()
        userMapper.updateById(user)
    }

    override fun list(param: PageParam<UserQuery>): PageInfo<UserItem> {
        val users = userMapper.select(PageDTO.of(param.page, param.size), param.query).toInfo(UserEntity::toItem)
        userRoleRelService.fillListByKey(users, UserItem::getId) { u, r ->
            u.roles = r.map(UserRoleRel::toRole)
        }
        roleService.fillList(users, UserItem::getRoles) { u, r ->
            u.roles = r
        }
        return users
    }

    @Transactional
    override fun insert(userInsert: UserInsert): Long {
        val entity = userInsert.toEntity()
        userMapper.insert(entity)
        userCertificateService.insert(entity.id, userInsert.pwd)
        userRoleRelService.insert(entity.id, userInsert.roleIds)
        return entity.id
    }

    @Transactional
    override fun update(userUpdate: UserUpdate) {
        val user = userMapper.selectById(userUpdate.id)
        user.chnName = userUpdate.chnName
        user.mobilePhoneNumber = userUpdate.mobilePhoneNumber
        user.emailAddress = userUpdate.emailAddress
        user.latestUpdateUserId = currentUser().id
        user.latestUpdateTime = LocalDateTime.now()
        userMapper.updateById(user)
        userRoleRelService.update(userUpdate.id, userUpdate.roleIds)
    }
}