package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.UfocusApplicationTests
import cn.dsc.ufocus.param.user.UserInsert
import cn.dsc.ufocus.param.user.UserUpdate
import cn.dsc.ufocus.service.UserService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithUserDetails
import org.springframework.transaction.annotation.Transactional

class UserServiceImplTest : UfocusApplicationTests() {

    val userId = 1735560201238421505L

    @Autowired
    lateinit var userService: UserService

    @Test
    fun loadUserByUsername() {
        val user = userService.loadUserByUsername("foreverhuiqiao@126.com")
        assertNotNull(user)
    }

    @WithUserDetails("foreverhuiqiao@126.com")
    @Transactional
    @Test
    fun insert() {
        userService.insert(UserInsert("周楷", "18800001234", "zhoukai@enhe.com", listOf(10000000L), "123456"))
    }

    @WithUserDetails("foreverhuiqiao@126.com")
    @Transactional
    @Test
    fun update() {
        val userUpdate = UserUpdate().apply {
            id = userId
            chnName = "张三"
            mobilePhoneNumber = "18800001234"
            emailAddress = "zhoukai@enhe.com"
            roleIds = listOf(10000000L)
        }
        userService.update(userUpdate)
    }

    @WithUserDetails("foreverhuiqiao@126.com")
    @Transactional
    @Test
    fun lock() {
        userService.lock(userId)
    }

    @WithUserDetails("foreverhuiqiao@126.com")
    @Transactional
    @Test
    fun unlock() {
        userService.lock(userId)
    }
}