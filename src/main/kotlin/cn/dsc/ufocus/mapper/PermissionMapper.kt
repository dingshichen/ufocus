// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.mapper

import cn.dsc.ufocus.entity.PermissionEntity
import cn.dsc.ufocus.param.permission.PermissionSelectQuery
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param

interface PermissionMapper : BaseMapper<PermissionEntity> {

    fun selectByQuery(@Param("query") query: PermissionSelectQuery): List<PermissionEntity>
}