// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-11

package cn.dsc.ufocus.control

import cn.dsc.ufocus.dto.R
import cn.dsc.ufocus.dto.success
import cn.dsc.ufocus.param.PageInfo
import cn.dsc.ufocus.param.PageParam
import cn.dsc.ufocus.param.user.*
import cn.dsc.ufocus.service.UserService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RequestMapping("/user")
@RestController
class UserController(
    val userService: UserService
) {

    @PreAuthorize("hasAuthority('USER_VIEW') or authentication.principal.id==#id")
    @GetMapping("/{id}")
    fun load(@PathVariable("id") id: Long): R<User> = success {
        userService.load(id)
    }

    @PreAuthorize("hasAuthority('USER_VIEW')")
    @PostMapping("/page")
    fun page(@RequestBody param: PageParam<UserQuery>): R<PageInfo<UserItem>> = success {
        userService.page(param)
    }

    @PreAuthorize("hasAuthority('USER_MANANGE')")
    @PostMapping("/insert")
    fun insert(@RequestBody @Validated userInsert: UserInsert): R<Long> = success {
        userService.insert(userInsert)
    }

    @PreAuthorize("hasAuthority('USER_MANANGE') or authentication.principal.id==#userUpdate.id")
    @PostMapping("/update")
    fun update(@RequestBody @Validated userUpdate: UserUpdate): R<*> = success {
        userService.update(userUpdate)
    }

    @PreAuthorize("hasAuthority('USER_MANANGE')")
    @PostMapping("/lock/{id}")
    fun lock(@PathVariable("id") id: Long): R<*> = success {
        userService.lock(id)
    }

    @PreAuthorize("hasAuthority('USER_MANANGE')")
    @PostMapping("/unlock/{id}")
    fun unlock(@PathVariable("id") id: Long): R<*> = success {
        userService.unlock(id)
    }
}