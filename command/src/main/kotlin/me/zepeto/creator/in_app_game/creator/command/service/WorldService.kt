package me.zepeto.creator.in_app_game.creator.command.service

import me.zepeto.creator.in_app_game.creator.domain.World
import me.zepeto.creator.in_app_game.creator.domain.WorldRepository
import org.springframework.stereotype.Service

@Service
class WorldService(private val worldRepository: WorldRepository) {

    fun save(world: World): World {
        return worldRepository.save(world)
    }


}
