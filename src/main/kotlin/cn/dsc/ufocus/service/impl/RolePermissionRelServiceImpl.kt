// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.consts.PermissionCode
import cn.dsc.ufocus.mapper.RolePermissionRelMapper
import cn.dsc.ufocus.service.RolePermissionRelService
import org.springframework.stereotype.Service

@Service
class RolePermissionRelServiceImpl(
    val rolePermissionRelMapper: RolePermissionRelMapper
) : RolePermissionRelService {

    override fun listPermissionsByRoleIds(roleIds: List<Long>): List<PermissionCode> {
        return rolePermissionRelMapper.selectPermissionsByRoleIds(roleIds)
    }
}