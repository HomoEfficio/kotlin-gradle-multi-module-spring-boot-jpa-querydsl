package me.zepeto.creator.in_app_game.creator.command

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@EntityScan(basePackages = ["me.zepeto.creator.in_app_game.creator.domain"])
@SpringBootApplication
class CommandApplication

fun main(args: Array<String>) {
    runApplication<CommandApplication>(*args)
}
