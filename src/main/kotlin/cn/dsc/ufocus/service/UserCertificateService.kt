// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-11

package cn.dsc.ufocus.service

import org.springframework.security.core.userdetails.UserDetailsPasswordService
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository

interface UserCertificateService : UserDetailsPasswordService, PersistentTokenRepository {

    fun loadPassword(userId: Long): String
    
    fun insert(userId: Long, pwd: String)
}