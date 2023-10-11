// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-11

package cn.dsc.ufocus.control

import cn.dsc.ufocus.dto.R
import cn.dsc.ufocus.dto.result
import cn.dsc.ufocus.entity.UserEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController {

    @GetMapping("/{id}")
    fun load(@PathVariable("id") id: Long): R<UserEntity> = result { UserEntity.builder().userId(id).build() }

}