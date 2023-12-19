// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-11

package cn.dsc.ufocus.service

import cn.dsc.ufocus.base.service.BaseFillService
import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.role.*

interface RoleService : BaseFillService<RoleOption> {

    fun load(id: Long): Role?

    fun select(query: RoleSelectQuery): List<RoleOption>

    fun page(param: PageParam<RoleQuery>): PageInfo<RoleItem>

    fun insert(roleInsert: RoleInsert): Long

    fun update(roleUpdate: RoleUpdate)

    fun delete(id: Long)
}