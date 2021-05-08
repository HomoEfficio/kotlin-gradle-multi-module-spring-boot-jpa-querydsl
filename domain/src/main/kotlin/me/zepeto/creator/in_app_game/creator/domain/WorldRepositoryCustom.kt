package me.zepeto.creator.in_app_game.creator.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface WorldRepositoryCustom {

    fun findAllByName(name: String, pageable: Pageable): Page<World>
}
