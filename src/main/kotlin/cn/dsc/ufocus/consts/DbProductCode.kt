// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.consts

import com.baomidou.mybatisplus.annotation.IEnum

enum class DbProductCode (
    val label: String
) : IEnum<String> {
    MYSQL("MySQL"),
    DAMENG("达梦"),
    GAUSSDB("高斯"),
    ;

    override fun getValue(): String {
        return this.name
    }
}