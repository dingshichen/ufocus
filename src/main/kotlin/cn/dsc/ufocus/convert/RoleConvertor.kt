// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-11

package cn.dsc.ufocus.convert

import cn.dsc.ufocus.entity.RoleEntity
import cn.dsc.ufocus.param.role.RoleOption

fun RoleEntity.toOption() = RoleOption().also {
    it.chnName = chnName
}