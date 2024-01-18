// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.service

import cn.dsc.ufocus.consts.PermissionCode
import cn.dsc.ufocus.param.permission.PermissionOption

interface RolePermissionRelService {

    /**
     * 根据角色id列表查询权限编码
     * @return 权限编码列表
     */
    fun listPermissionsByRoleIds(roleIds: List<Long>): List<PermissionCode>

    fun selectByRoleId(roleId: Long): List<PermissionOption>
}