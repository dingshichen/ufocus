// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-11

package cn.dsc.ufocus.util

import org.junit.jupiter.api.Test
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

class PasswordTest {

    private val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Test
    fun createPassword() {
        val encode = passwordEncoder.encode("admin")
        println(encode)
    }
}