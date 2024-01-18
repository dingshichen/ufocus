// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.service

import cn.dsc.ufocus.base.service.BaseFillService
import cn.dsc.ufocus.param.permission.PermissionOption
import cn.dsc.ufocus.param.permission.PermissionSelectQuery

interface PermissionService : BaseFillService<PermissionOption> {

    fun select(query: PermissionSelectQuery): List<PermissionOption>
}