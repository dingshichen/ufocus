// @author  ding.shichen
// @email   foreverhuiqiao@126.com
// @date    2023-11-06

package cn.dsc.ufocus.exception

class EntityNotFoundException(message: String? = null) : RuntimeException(message)

class CurrentUserNotFoundException(message: String? = null) : RuntimeException(message)