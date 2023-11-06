// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.mapper

import cn.dsc.ufocus.entity.UserEntity
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param

interface UserMapper : BaseMapper<UserEntity> {

    fun selectByEmail(@Param("emailAddress") emailAddress: String): UserEntity?

}