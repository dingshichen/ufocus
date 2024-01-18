// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-20

package cn.dsc.ufocus.control

import cn.dsc.ufocus.consts.PRMS_ROLE_VIEW
import cn.dsc.ufocus.dto.R
import cn.dsc.ufocus.dto.success
import cn.dsc.ufocus.param.permission.PermissionOption
import cn.dsc.ufocus.param.permission.PermissionSelectQuery
import cn.dsc.ufocus.service.PermissionService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/permission")
@RestController
class PermissionController(
    val permissionService: PermissionService
) {

    @PreAuthorize("hasAuthority('$PRMS_ROLE_VIEW')")
    @GetMapping("/select")
    fun select(query: PermissionSelectQuery): R<List<PermissionOption>> = success {
        permissionService.select(query)
    }
}