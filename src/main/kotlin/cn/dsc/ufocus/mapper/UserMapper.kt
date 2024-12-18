// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.mapper

import cn.dsc.ufocus.entity.UserEntity
import cn.dsc.ufocus.param.user.UserQuery
import cn.dsc.ufocus.param.user.UserSelectQuery
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import org.apache.ibatis.annotations.Param

interface UserMapper : BaseMapper<UserEntity> {

    fun selectByAccountNo(@Param("accountNo") accountNo: String): UserEntity?

    fun selectByQuery(@Param("page") page: IPage<UserEntity>, @Param("query") query: UserQuery): IPage<UserEntity>

    fun select(@Param("query") query: UserSelectQuery): List<UserEntity>

}