package me.zepeto.creator.in_app_game.creator.query.service

import me.zepeto.creator.in_app_game.creator.domain.World
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.jdbc.Sql

@DataJpaTest
@Import(WorldService::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class WorldServiceTest {

    @Autowired
    private lateinit var worldService: WorldService

    @Test
    @Sql(scripts = ["classpath:sql/data-h2.sql"])
    internal fun `월드 페이징 조회`() {
        val pagedResult: Page<World> = worldService.findAllByName("월드", PageRequest.of(0, 2))

        assertThat(pagedResult.totalElements).isEqualTo(5)
        assertThat(pagedResult.totalPages).isEqualTo(3)
    }
}
