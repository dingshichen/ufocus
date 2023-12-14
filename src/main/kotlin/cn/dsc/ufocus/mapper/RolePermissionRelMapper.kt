// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.mapper

import cn.dsc.ufocus.consts.PermissionCode
import cn.dsc.ufocus.entity.RolePermissionRelEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param

interface RolePermissionRelMapper : BaseMapper<RolePermissionRelEntity> {

    fun selectPermissionsByRoleIds(@Param("roleIds") roleIds: List<Long>): List<PermissionCode>
}