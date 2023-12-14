// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-10-10

package cn.dsc.ufocus.mapper

import cn.dsc.ufocus.entity.RoleEntity
import cn.dsc.ufocus.param.role.RoleQuery
import cn.dsc.ufocus.param.role.RoleSelectQuery
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import org.apache.ibatis.annotations.Param

interface RoleMapper : BaseMapper<RoleEntity> {

    fun selectBySelectQuery(@Param("query") query: RoleSelectQuery): List<RoleEntity>

    fun select(@Param("page") page: IPage<RoleEntity>, @Param("query") query: RoleQuery): IPage<RoleEntity>
}