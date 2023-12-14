// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-11

package cn.dsc.ufocus.config

import cn.dsc.ufocus.currentUser
import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.apache.ibatis.reflection.MetaObject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import java.util.function.Supplier

@Configuration
class MybatisPlusConfiguration {

    @Bean
    fun mybatisPlusInterceptor(): MybatisPlusInterceptor {
        return MybatisPlusInterceptor().also {
            // 如果有多数据源可以不配具体类型 否则都建议配上具体的 DbType
            it.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))
        }
    }

    @Bean
    fun metaObjectHandler(): MetaObjectHandler {
        return object : MetaObjectHandler {
            override fun insertFill(metaObject: MetaObject) {
                val currentUser = currentUser()
                val now = LocalDateTime.now()
                this.strictInsertFill(metaObject, "createUserId", { currentUser.id }, Long::class.java)
                this.strictInsertFill(metaObject, "createTime", { now }, LocalDateTime::class.java)
                this.strictInsertFill(metaObject, "latestUpdateUserId", { currentUser.id }, Long::class.java)
                this.strictInsertFill(metaObject, "latestUpdateTime", { now }, LocalDateTime::class.java)
            }

            override fun updateFill(metaObject: MetaObject) {
                val currentUser = currentUser()
                val now = LocalDateTime.now()
                this.strictUpdateFill(metaObject, "latestUpdateUserId", { currentUser.id }, Long::class.java)
                this.strictUpdateFill(metaObject, "latestUpdateTime", { now }, LocalDateTime::class.java)
            }

            /**
             * 有没有值都填充
             */
            override fun strictFillStrategy(metaObject: MetaObject, fieldName: String, fieldVal: Supplier<*>): MetaObjectHandler {
                fieldVal.get()?.let {
                    metaObject.setValue(fieldName, it)
                }
                return this
            }
        }
    }
}