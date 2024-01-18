// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.convert.toOption
import cn.dsc.ufocus.entity.PermissionEntity
import cn.dsc.ufocus.mapper.PermissionMapper
import cn.dsc.ufocus.param.permission.PermissionOption
import cn.dsc.ufocus.param.permission.PermissionSelectQuery
import cn.dsc.ufocus.service.PermissionService
import org.springframework.stereotype.Service

@Service
class PermissionServiceImpl(
    val permissionMapper: PermissionMapper
) : PermissionService {

    override fun select(query: PermissionSelectQuery): List<PermissionOption> {
        return permissionMapper.selectByQuery(query).map(PermissionEntity::toOption)
    }

    override fun listByIds(ids: List<Long>): List<PermissionOption> {
        return permissionMapper.selectBatchIds(ids).map(PermissionEntity::toOption)
    }

}