// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-20

package cn.dsc.ufocus.convert

import cn.dsc.ufocus.entity.PermissionEntity
import cn.dsc.ufocus.param.permission.PermissionOption

fun PermissionEntity.toOption() = PermissionOption().also {
    it.id = id
    it.permissionName = permissionName
}