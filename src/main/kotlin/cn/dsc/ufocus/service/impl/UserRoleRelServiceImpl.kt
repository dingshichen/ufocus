// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-11

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.convert.toDetail
import cn.dsc.ufocus.entity.UserRoleRelEntity
import cn.dsc.ufocus.mapper.UserRoleRelMapper
import cn.dsc.ufocus.param.user.UserRoleRel
import cn.dsc.ufocus.service.UserRoleRelService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserRoleRelServiceImpl(
    val userRoleRelMapper: UserRoleRelMapper
) : UserRoleRelService {

    override fun listByKeys(keys: List<Long>): List<UserRoleRel> {
        val items = userRoleRelMapper.selectByUserIds(keys)
        return items.map { it.toDetail() }
    }

    @Transactional
    override fun insert(userId: Long, roleIds: List<Long>) {
        val entities = roleIds.map { roleId ->
            UserRoleRelEntity().also {
                it.userId = userId
                it.roleId = roleId
            }
        }
        userRoleRelMapper.insertBatch(entities)
    }
}