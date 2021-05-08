package me.zepeto.creator.in_app_game.creator.query.service

import me.zepeto.creator.in_app_game.creator.domain.model.World
import me.zepeto.creator.in_app_game.creator.domain.repository.WorldRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class WorldService(
    private val worldRepository: WorldRepository
) {

    fun findAllByName(name: String, pageable: Pageable): Page<World> {
        return worldRepository.findAllByName(name, pageable)
    }
}
