// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.mapper

import cn.dsc.ufocus.entity.UserRoleRelEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param

interface UserRoleRelMapper : BaseMapper<UserRoleRelEntity> {

    fun selectByUserId(@Param("userId") userId: Long): List<UserRoleRelEntity>

    fun selectByUserIds(@Param("userIds") userIds: List<Long>): List<UserRoleRelEntity>

    fun selectRoleIdsByUserId(@Param("userId") userId: Long): List<Long>

    fun insertByIds(@Param("userId") userId: Long, @Param("roleIds") roleIds: List<Long>)

    fun deleteByIds(@Param("userId") userId: Long, @Param("roleIds") roleIds: List<Long>)
}