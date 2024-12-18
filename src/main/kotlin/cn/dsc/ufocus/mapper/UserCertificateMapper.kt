// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.mapper

import cn.dsc.ufocus.entity.UserCertificateEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken
import java.util.*

interface UserCertificateMapper : BaseMapper<UserCertificateEntity> {

    fun selectPassword(@Param("userId") userId: Long): String

    fun updatePassword(@Param("userId") userId: Long, @Param("newPassword") newPassword: String)

    fun updateRememberMe(
        @Param("userId") userId: Long,
        @Param("rememberMeSeries") rememberMeSeries: String,
        @Param("rememberMeToken") rememberMeToken: String,
        @Param("rememberMeLatestUseTime") rememberMeLatestUseTime: Date
    )

    fun updateRememberMeBySeries(
        @Param("rememberMeSeries") rememberMeSeries: String,
        @Param("rememberMeToken") rememberMeToken: String,
        @Param("rememberMeLatestUseTime") rememberMeLatestUseTime: Date)

    fun selectRememberMeBySeries(@Param("rememberMeSeries") rememberMeSeries: String): PersistentRememberMeToken?

    fun clearRememberMeByAccountNo(@Param("accountNo") accountNo: String)
}