// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-12-14

package cn.dsc.ufocus.consts

import com.baomidou.mybatisplus.annotation.IEnum

enum class TicketAuditState(
    val label: String
) : IEnum<String> {

    WAITING("待审核"),
    EXECUTING("审核中"),
    PASS("已通过"),
    REJECT("被驳回"),
    UNDO("已撤销"),
    ;

    override fun getValue(): String {
        return this.name
    }
}