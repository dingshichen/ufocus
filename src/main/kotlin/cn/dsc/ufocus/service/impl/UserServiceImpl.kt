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
import cn.dsc.ufocus.service.*
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class UserServiceImpl(
    val userMapper: UserMapper,
) : UserService {

    @Autowired
    private lateinit var userCertificateService: UserCertificateService

    @Autowired
    private lateinit var roleService: RoleService

    @Autowired
    private lateinit var userRoleRelService: UserRoleRelService

    @Autowired
    private lateinit var rolePermissionRelService: RolePermissionRelService

    override fun loadUserByUsername(username: String): UserDetails {
        val entity = userMapper.selectByEmail(username) ?: throw UsernameNotFoundException("获取不到用户")
        val password = userCertificateService.loadPassword(entity.id)
        val roleIds = userRoleRelService.listRoleIdsByUserId(entity.id)
        val permissions = rolePermissionRelService.listPermissionsByRoleIds(roleIds)
        return UserDetail(entity.id, entity.emailAddress, password, entity.isLockFlag, permissions)
    }

    override fun listByIds(ids: List<Long>): List<UserOption> {
        return userMapper.selectBatchIds(ids).map(UserEntity::toOption)
    }

    override fun load(id: Long): User? {
        return userMapper.selectById(id)?.toDetail()?.also {
            userRoleRelService.fillListByKey(it, UserItem::getId) { u, r ->
                u.roles = r.map(UserRoleRel::toRole)
            }
            roleService.fillList(it, UserItem::getRoles, UserItem::setRoles)
            this.fill(it, User::getCreateUser, User::setCreateUser)
            this.fill(it, User::getLatestUpdateUser, User::setLatestUpdateUser)
        }
    }

    override fun select(query: UserSelectQuery): List<UserOption> {
        return userMapper.select(query).map(UserEntity::toOption)
    }

    override fun page(param: PageParam<UserQuery>): PageInfo<UserItem> {
        val users = userMapper.selectByQuery(PageDTO.of(param.page, param.size), param.query).toInfo(UserEntity::toItem)
        userRoleRelService.fillListByKey(users, UserItem::getId) { u, r ->
            u.roles = r.map(UserRoleRel::toRole)
        }
        roleService.fillList(users, UserItem::getRoles, UserItem::setRoles)
        return users
    }

    @Transactional
    override fun insert(userInsert: UserInsert): Long {
        val entity = UserEntity().also {
            it.chnName = userInsert.chnName
            it.emailAddress = userInsert.emailAddress
            it.mobilePhoneNumber = userInsert.mobilePhoneNumber
            it.isLockFlag = false
        }
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
        userMapper.updateById(user)
        userRoleRelService.update(userUpdate.id, userUpdate.roleIds)
    }

    @Transactional
    override fun lock(id: Long) {
        val user = userMapper.selectById(id) ?: throw EntityNotFoundException("用户不存在")
        user.isLockFlag = true
        user.latestUpdateUserId = currentUser().id
        user.latestUpdateTime = LocalDateTime.now()
        userMapper.updateById(user)
    }

    @Transactional
    override fun unlock(id: Long) {
        val user = userMapper.selectById(id) ?: throw EntityNotFoundException("用户不存在")
        user.isLockFlag = false
        userMapper.updateById(user)
    }
}