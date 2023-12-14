// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-31

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.convert.toInfo
import cn.dsc.ufocus.convert.toItem
import cn.dsc.ufocus.convert.toOption
import cn.dsc.ufocus.entity.RoleEntity
import cn.dsc.ufocus.mapper.RoleMapper
import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.role.*
import cn.dsc.ufocus.service.RoleService
import cn.dsc.ufocus.service.UserService
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl(
    val roleMapper: RoleMapper,
    val userService: UserService,
) : RoleService {

    override fun listByIds(ids: List<Long>): List<RoleOption> {
        val roles = roleMapper.selectBatchIds(ids)
        return roles.map(RoleEntity::toOption)
    }

    override fun select(query: RoleSelectQuery): List<RoleOption> {
        val roles = roleMapper.selectBySelectQuery(query)
        return roles.map(RoleEntity::toOption)
    }

    override fun page(param: PageParam<RoleQuery>): PageInfo<RoleItem> {
        val roles = roleMapper.select(PageDTO.of(param.page, param.size), param.query).toInfo(RoleEntity::toItem)
        userService.fill(roles, RoleItem::getCreateUser, RoleItem::setCreateUser)
        return roles
    }

    override fun insert(roleInsert: RoleInsert): Long {
        val role = RoleEntity().also {
            it.chnName = roleInsert.chnName
        }
        roleMapper.insert(role)
        return role.id
    }

    override fun update(roleUpdate: RoleUpdate) {
        val role = roleMapper.selectById(roleUpdate.id)
        role.chnName = roleUpdate.chnName
        roleMapper.updateById(role)
    }
}