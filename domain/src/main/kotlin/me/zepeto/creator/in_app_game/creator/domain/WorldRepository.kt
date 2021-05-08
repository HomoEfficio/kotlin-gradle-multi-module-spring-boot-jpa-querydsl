package me.zepeto.creator.in_app_game.creator.domain

import me.zepeto.creator.in_app_game.creator.domain.model.World
import org.springframework.data.jpa.repository.JpaRepository

interface WorldRepository: JpaRepository<World, Long>, WorldRepositoryCustom {
}
