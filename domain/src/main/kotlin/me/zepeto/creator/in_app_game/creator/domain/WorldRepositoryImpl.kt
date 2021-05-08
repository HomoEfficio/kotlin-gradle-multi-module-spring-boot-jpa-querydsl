package me.zepeto.creator.in_app_game.creator.domain

import me.zepeto.creator.in_app_game.creator.domain.model.QWorld
import me.zepeto.creator.in_app_game.creator.domain.model.World
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository

@Repository
class WorldRepositoryImpl: QuerydslRepositorySupport(World::class.java), WorldRepositoryCustom {
    private val qWorld = QWorld.world

    override fun findAllByName(name: String, pageable: Pageable): Page<World> {
        val result = from(qWorld)
            .where(qWorld.name.contains(name))
            .fetchAll()
        val pagedResult = querydsl!!.applyPagination(pageable, result).fetch()
        return PageableExecutionUtils.getPage(pagedResult, pageable, result::fetchCount)
    }
}
