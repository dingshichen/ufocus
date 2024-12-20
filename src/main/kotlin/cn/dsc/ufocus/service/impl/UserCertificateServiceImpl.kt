// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.currentUser
import cn.dsc.ufocus.entity.UserCertificateEntity
import cn.dsc.ufocus.mapper.UserCertificateMapper
import cn.dsc.ufocus.param.user.UserDetail
import cn.dsc.ufocus.service.UserCertificateService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserCertificateServiceImpl(
    val userCertificateMapper: UserCertificateMapper,
    val passwordEncoder: PasswordEncoder,
) : UserCertificateService {

    override fun loadPassword(userId: Long): String {
        return userCertificateMapper.selectPassword(userId)
    }

    @Transactional
    override fun insert(userId: Long, pwd: String) {
        UserCertificateEntity().also {
            it.userId = userId
            it.pwd = passwordEncoder.encode(pwd)
            userCertificateMapper.insert(it)
        }
    }

    override fun updatePassword(user: UserDetails, newPassword: String): UserDetails {
        userCertificateMapper.updatePassword((user as UserDetail).id, newPassword)
        user.password = newPassword
        return user
    }

    override fun createNewToken(token: PersistentRememberMeToken) {
        userCertificateMapper.updateRememberMe(currentUser().id, token.series, token.tokenValue, token.date)
    }

    override fun updateToken(series: String, tokenValue: String, lastUsed: Date) {
        userCertificateMapper.updateRememberMeBySeries(series, tokenValue, lastUsed)
    }

    override fun getTokenForSeries(series: String): PersistentRememberMeToken? {
        val rememberMe = userCertificateMapper.selectRememberMeBySeries(series) ?: return null
        if (rememberMe.tokenValue.isNullOrBlank()) {
            return null
        }
        return rememberMe
    }

    override fun removeUserTokens(username: String) {
        userCertificateMapper.clearRememberMeByAccountNo(username)
    }
}