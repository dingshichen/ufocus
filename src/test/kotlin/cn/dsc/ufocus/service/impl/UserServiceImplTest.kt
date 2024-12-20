package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.UfocusApplicationTests
import cn.dsc.ufocus.WithAdminUserDetail
import cn.dsc.ufocus.param.user.UserInsert
import cn.dsc.ufocus.param.user.UserUpdate
import cn.dsc.ufocus.service.UserService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
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

    @WithAdminUserDetail
    @Transactional
    @Test
    fun insert() {
        userService.insert(UserInsert("周楷", "18800001234", "zhoukai@enhe.com", listOf(10000000L), "123456"))
    }

    @WithAdminUserDetail
    @Transactional
    @Test
    fun update() {
        val userUpdate = UserUpdate().apply {
            id = userId
            userName = "张三"
            phoneNo = "18800001234"
            email = "zhoukai@enhe.com"
            roleIds = listOf(10000000L)
        }
        userService.update(userUpdate)
    }

    @WithAdminUserDetail
    @Transactional
    @Test
    fun lock() {
        userService.lock(userId)
    }

    @WithAdminUserDetail
    @Transactional
    @Test
    fun unlock() {
        userService.lock(userId)
    }
}