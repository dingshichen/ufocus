package cn.dsc.ufocus

import org.springframework.security.test.context.support.WithUserDetails

/**
 * 使用 Admin 用户去操作，会先去获取 foreverhuiqiao@126.com 的用户信息
 */
@WithUserDetails("foreverhuiqiao@126.com")
annotation class WithAdminUserDetail
