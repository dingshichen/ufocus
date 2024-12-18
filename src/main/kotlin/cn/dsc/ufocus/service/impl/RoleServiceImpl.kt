// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-31

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.convert.toDetail
import cn.dsc.ufocus.convert.toPageInfo
import cn.dsc.ufocus.convert.toItem
import cn.dsc.ufocus.convert.toOption
import cn.dsc.ufocus.entity.RoleEntity
import cn.dsc.ufocus.mapper.RoleMapper
import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.role.*
import cn.dsc.ufocus.service.RolePermissionRelService
import cn.dsc.ufocus.service.RoleService
import cn.dsc.ufocus.service.UserService
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RoleServiceImpl(
    val roleMapper: RoleMapper,
    val rolePermissionRelService: RolePermissionRelService,
) : RoleService {

    @Autowired
    private lateinit var userService: UserService

    override fun listByIds(ids: List<Long>): List<RoleOption> {
        val roles = roleMapper.selectByIds(ids)
        return roles.map(RoleEntity::toOption)
    }

    override fun load(id: Long): Role? {
        return roleMapper.selectById(id)?.toDetail()?.apply {
            userService.fill(this, Role::getCreateUser, Role::setCreateUser)
            userService.fill(this, Role::getUpdateUser, Role::setUpdateUser)
        }
    }

    override fun select(query: RoleSelectQuery): List<RoleOption> {
        val roles = roleMapper.selectBySelectQuery(query)
        return roles.map(RoleEntity::toOption)
    }

    override fun page(param: PageParam<RoleQuery>): PageInfo<RoleItem> {
        val ipage: IPage<RoleEntity> = roleMapper.select(PageDTO.of(param.page, param.size), param.query)
        val roles = ipage.toPageInfo { it.toItem() }
        userService.fill(roles, RoleItem::getCreateUser, RoleItem::setCreateUser)
        return roles
    }

    @Transactional
    override fun delete(id: Long) {
        roleMapper.deleteById(id)
        rolePermissionRelService.deleteByRoleId(id)
    }

    @Transactional
    override fun insert(roleInsert: RoleInsert): Long {
        val role = RoleEntity().also {
            it.roleName = roleInsert.roleName
        }
        roleMapper.insert(role)
        rolePermissionRelService.insertBatch(role.id, roleInsert.permissionIds)
        return role.id
    }

    @Transactional
    override fun update(roleUpdate: RoleUpdate) {
        val role = roleMapper.selectById(roleUpdate.id)
        role.roleName = roleUpdate.roleName
        roleMapper.updateById(role)
        rolePermissionRelService.replace(roleUpdate.id, roleUpdate.permissionIds)
    }
}