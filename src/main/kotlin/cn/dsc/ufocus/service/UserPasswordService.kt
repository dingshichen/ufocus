// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-11

package cn.dsc.ufocus.service

import org.springframework.security.core.userdetails.UserDetailsPasswordService

interface UserPasswordService : UserDetailsPasswordService {

    fun loadPassword(userId: Long): String
}