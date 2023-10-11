// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.service

import org.springframework.security.core.userdetails.UserDetailsPasswordService
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService : UserDetailsService, UserDetailsPasswordService