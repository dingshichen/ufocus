// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-14

package cn.dsc.ufocus.config

import cn.dsc.ufocus.consts.RStatus
import cn.dsc.ufocus.dto.fail
import cn.dsc.ufocus.dto.success
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

/**
 * 安全策略配置
 */
@Slf4j
@Configuration
class SecurityConfiguration {

    private val log: Logger = LoggerFactory.getLogger(SecurityConfiguration::class.java)

    @Bean
    fun filterChain(http: HttpSecurity, objectMapper: ObjectMapper): SecurityFilterChain {
        return http.authorizeHttpRequests {
            it.mvcMatchers("/api/index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/auth/password")
                .permitAll()
                .successHandler { _, res, _ ->
                    res.status = HttpStatus.OK.value()
                    res.contentType = MediaType.APPLICATION_JSON_VALUE
                    res.characterEncoding = Charsets.UTF_8.name()
                    res.writer.println(objectMapper.writeValueAsString(success()))
                }
                .failureHandler { _, res, _ ->
                    res.status = HttpStatus.OK.value()
                    res.contentType = MediaType.APPLICATION_JSON_VALUE
                    res.characterEncoding = Charsets.UTF_8.name()
                    res.writer.println(objectMapper.writeValueAsString(fail(RStatus.LOGIN_FAIL)))
                }
                .and()
                .logout()
                .logoutUrl("/auth/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessHandler { _, res, _ ->
                    res.status = HttpStatus.OK.value()
                    res.contentType = MediaType.APPLICATION_JSON_VALUE
                    res.characterEncoding = Charsets.UTF_8.name()
                    res.writer.println(objectMapper.writeValueAsString(success()))
                }
                .and()
                .exceptionHandling { conf ->
                    conf.authenticationEntryPoint { _, res, _ ->
                        // 未认证的请求，返回 401
                        res.sendError(HttpStatus.UNAUTHORIZED.value())
                    }
                    conf.accessDeniedHandler { _, res, _ ->
                        // 未授权的请求，返回 403
                        res.sendError(HttpStatus.FORBIDDEN.value())
                    }
                }
                .csrf()
                .disable()
        }.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}