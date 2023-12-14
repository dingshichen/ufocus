package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.UfocusApplicationTests
import cn.dsc.ufocus.service.UserService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserServiceImplTest : UfocusApplicationTests() {

    @Autowired
    lateinit var userService: UserService

    @Test
    fun loadUserByUsername() {
        val user = userService.loadUserByUsername("foreverhuiqiao@126.com")
        assertNotNull(user)
    }

    @Test
    fun listByIds() {
    }

    @Test
    fun load() {
    }

    @Test
    fun page() {
    }

    @Test
    fun insert() {
    }

    @Test
    fun update() {
    }

    @Test
    fun lock() {
    }

    @Test
    fun unlock() {
    }
}