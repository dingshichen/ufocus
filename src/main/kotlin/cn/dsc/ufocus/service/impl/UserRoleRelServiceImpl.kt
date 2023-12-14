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
        return items.map(UserRoleRelEntity::toDetail)
    }

    override fun listRoleIdsByUserId(userId: Long): List<Long> {
        return userRoleRelMapper.selectRoleIdsByUserId(userId)
    }

    @Transactional
    override fun insert(userId: Long, roleIds: List<Long>) {
        userRoleRelMapper.insertByIds(userId, roleIds)
    }

    @Transactional
    override fun update(userId: Long, roleIds: List<Long>) {
        val entities = userRoleRelMapper.selectByUserId(userId)
        val ids = entities.map { it.roleId }
        val insertRoleIds = roleIds.filter { it !in ids }
        val deleteRoleIds = ids.filter { it !in roleIds }
        if (insertRoleIds.isNotEmpty()) {
            insert(userId, insertRoleIds)
        }
        if (deleteRoleIds.isNotEmpty()) {
            userRoleRelMapper.deleteByIds(userId, deleteRoleIds)
        }
    }
}