// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.consts

import com.baomidou.mybatisplus.annotation.IEnum

enum class ScriptPerformState(
    val label: String
) : IEnum<String> {
    WAITING("待执行"),
    EXECUTING("执行中"),
    SUCCESS("执行成功"),
    FAILED("执行失败"),;

    override fun getValue(): String {
        return this.name
    }
}