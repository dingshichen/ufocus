// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.consts.PermissionCode
import cn.dsc.ufocus.mapper.RolePermissionRelMapper
import cn.dsc.ufocus.param.permission.PermissionOption
import cn.dsc.ufocus.service.PermissionService
import cn.dsc.ufocus.service.RolePermissionRelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RolePermissionRelServiceImpl(
    val rolePermissionRelMapper: RolePermissionRelMapper
) : RolePermissionRelService {

    @Autowired
    private lateinit var permissionService: PermissionService

    override fun listPermissionsByRoleIds(roleIds: List<Long>): List<PermissionCode> {
        return rolePermissionRelMapper.selectPermissionsByRoleIds(roleIds)
    }

    override fun selectByRoleId(roleId: Long): List<PermissionOption> {
        val options = rolePermissionRelMapper.selectByRoleId(roleId).map { entity ->
            PermissionOption().also {
                it.id = entity.permissionId
            }
        }
        permissionService.fillById(options, { s: PermissionOption -> s.id }) { s, o ->
            s.permissionName = o?.permissionName
        }
        return options
    }

    @Transactional
    override fun insertBatch(roleId: Long, permissionIds: List<Long>) {
        rolePermissionRelMapper.insertBatch(roleId, permissionIds)
    }

    @Transactional
    override fun replace(roleId: Long, permissionIds: List<Long>) {
        val beforePermissionIds = rolePermissionRelMapper.selectPermissionIdsByRoleId(roleId)
        // 新增集合
        permissionIds.filter { it !in beforePermissionIds }.let {
            if (it.isNotEmpty()) {
                rolePermissionRelMapper.insertBatch(roleId, it)
            }
        }
        // 删除集合
        beforePermissionIds.filter { it !in permissionIds }.let {
            if (it.isNotEmpty()) {
                rolePermissionRelMapper.deletePermissions(roleId, it)
            }
        }
    }

    @Transactional
    override fun deleteByRoleId(roleId: Long) {
        rolePermissionRelMapper.deleteByRoleId(roleId)
    }
}