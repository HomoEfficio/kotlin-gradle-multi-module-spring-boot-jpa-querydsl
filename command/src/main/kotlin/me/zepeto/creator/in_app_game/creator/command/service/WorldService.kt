package me.zepeto.creator.in_app_game.creator.command.service

import me.zepeto.creator.in_app_game.creator.domain.model.World
import me.zepeto.creator.in_app_game.creator.domain.repository.WorldRepository
import org.springframework.stereotype.Service

@Service
class WorldService(private val worldRepository: WorldRepository) {

    fun save(world: World): World {
        return worldRepository.save(world)
    }


}
