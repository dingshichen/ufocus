// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-11

package cn.dsc.ufocus.control

import cn.dsc.ufocus.dto.R
import cn.dsc.ufocus.dto.success
import cn.dsc.ufocus.param.user.User
import cn.dsc.ufocus.service.UserService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RequestMapping("/user")
@RestController
class UserController(
    val userService: UserService
) {

    @PreAuthorize("hasAuthority('USER_MANANGE') or authentication.principal.id==#id")
    @GetMapping("/{id}")
    fun load(@PathVariable("id") id: Long): R<User> = success {
        userService.load(id)
    }

    @PreAuthorize("hasAuthority('USER_MANANGE')")
    @PostMapping("/lock/{id}")
    fun lock(@PathVariable("id") id: Long): R<Any> = success {
        userService.lock(id)
    }
}