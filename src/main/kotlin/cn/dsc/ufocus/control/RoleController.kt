// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.control

import cn.dsc.ufocus.consts.PRMS_ROLE_MANAGE
import cn.dsc.ufocus.consts.PRMS_ROLE_VIEW
import cn.dsc.ufocus.dto.R
import cn.dsc.ufocus.dto.success
import cn.dsc.ufocus.exception.OperationDeniedException
import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.role.*
import cn.dsc.ufocus.service.RoleService
import cn.dsc.ufocus.service.UserRoleRelService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RequestMapping("/role")
@RestController
class RoleController(
    val roleService: RoleService,
    val userRoleRelService: UserRoleRelService,
) {

    @PreAuthorize("hasAuthority('$PRMS_ROLE_VIEW')")
    @GetMapping("/{id}")
    fun load(@PathVariable id: Long): R<Role> = success {
        roleService.load(id)
    }

    @GetMapping("/select")
    fun select(query: RoleSelectQuery): R<List<RoleOption>> = success {
        roleService.select(query)
    }

    @PreAuthorize("hasAuthority('$PRMS_ROLE_VIEW')")
    @PostMapping("/page")
    fun page(@RequestBody param: PageParam<RoleQuery>): R<PageInfo<RoleItem>> = success {
        roleService.page(param)
    }

    @PreAuthorize("hasAuthority('$PRMS_ROLE_MANAGE')")
    @PostMapping("/insert")
    fun insert(@RequestBody @Validated roleInsert: RoleInsert): R<Long> = success {
        roleService.insert(roleInsert)
    }

    @PreAuthorize("hasAuthority('$PRMS_ROLE_MANAGE')")
    @PostMapping("/update")
    fun update(@RequestBody @Validated roleUpdate: RoleUpdate): R<*> = success {
        roleService.update(roleUpdate)
    }

    @PreAuthorize("hasAuthority('$PRMS_ROLE_MANAGE')")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): R<*> = success {
        val hasUser = userRoleRelService.existByRoleId(id)
        if (hasUser) {
            throw OperationDeniedException("该角色下仍有用户数据，不允许删除")
        }
        roleService.delete(id)
    }

}