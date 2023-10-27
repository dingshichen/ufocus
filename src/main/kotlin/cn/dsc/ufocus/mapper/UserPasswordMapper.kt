// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.mapper

import cn.dsc.ufocus.entity.UserPasswordEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param

interface UserPasswordMapper : BaseMapper<UserPasswordEntity> {

    fun selectPassword(@Param("userId") userId: Long): String

    fun updatePassword(@Param("userId") userId: Long, @Param("newPassword") newPassword: String)
}