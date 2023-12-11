// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-31

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.convert.toOption
import cn.dsc.ufocus.mapper.RoleMapper
import cn.dsc.ufocus.param.role.RoleOption
import cn.dsc.ufocus.service.RoleService
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl(
    val roleMapper: RoleMapper,
) : RoleService {

    override fun listByIds(ids: List<Long>): List<RoleOption> {
        val roles = roleMapper.selectBatchIds(ids)
        return roles.map { it.toOption() }
    }

}