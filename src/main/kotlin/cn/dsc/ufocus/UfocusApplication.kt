package cn.dsc.ufocus

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan("cn.dsc.ufocus.mapper")
@SpringBootApplication
class UfocusApplication

fun main(args: Array<String>) {
    runApplication<UfocusApplication>(*args)
}
