package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.UfocusApplicationTests
import cn.dsc.ufocus.service.RolePermissionRelService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class RolePermissionRelServiceImplTest : UfocusApplicationTests() {

    @Autowired
    lateinit var rolePermissionRelService: RolePermissionRelService

    @Test
    fun listPermissionsByRoleIds() {
        val permissionCodes = rolePermissionRelService.listPermissionsByRoleIds(listOf(10000000L))
        assertNotNull(permissionCodes)
    }
}