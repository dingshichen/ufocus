// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-22

package cn.dsc.ufocus.service.impl

import cn.dsc.ufocus.mapper.UserCertificateMapper
import cn.dsc.ufocus.param.user.UserDetail
import cn.dsc.ufocus.service.UserCertificateService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserCertificateServiceImpl(
    val userCertificateMapper: UserCertificateMapper
) : UserCertificateService {

    override fun loadPassword(userId: Long): String {
        return userCertificateMapper.selectPassword(userId)
    }

    override fun updatePassword(user: UserDetails, newPassword: String): UserDetails {
        userCertificateMapper.updatePassword((user as UserDetail).id, newPassword)
        user.password = newPassword
        return user
    }

    override fun createNewToken(token: PersistentRememberMeToken) {
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetail
        userCertificateMapper.updateRememberMe(user.id, token.series, token.tokenValue, token.date)
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
        userCertificateMapper.clearRememberMeByEmailAddress(username)
    }
}