// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.control

import cn.dsc.ufocus.dto.R
import cn.dsc.ufocus.dto.success
import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.role.*
import cn.dsc.ufocus.service.RoleService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RequestMapping("/role")
@RestController
class RoleController(
    val roleService: RoleService,
) {

    @GetMapping("/select")
    fun select(@RequestParam query: RoleSelectQuery): R<List<RoleOption>> = success {
        roleService.select(query)
    }

    @PreAuthorize("hasAuthority('ROLE_VIEW')")
    @PostMapping("/page")
    fun page(@RequestBody param: PageParam<RoleQuery>): R<PageInfo<RoleItem>> = success {
        roleService.page(param)
    }

    @PreAuthorize("hasAuthority('ROLE_MANAGE')")
    @PostMapping("/insert")
    fun insert(@RequestBody @Validated roleInsert: RoleInsert): R<Long> = success {
        roleService.insert(roleInsert)
    }

    @PreAuthorize("hasAuthority('ROLE_MANAGE')")
    @PostMapping("/update")
    fun update(@RequestBody @Validated roleUpdate: RoleUpdate): R<*> = success {
        roleService.update(roleUpdate)
    }

}