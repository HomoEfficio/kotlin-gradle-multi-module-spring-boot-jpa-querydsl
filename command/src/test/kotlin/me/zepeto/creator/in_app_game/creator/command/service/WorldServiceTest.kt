package me.zepeto.creator.in_app_game.creator.command.service

import me.zepeto.creator.in_app_game.creator.domain.World
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@DataJpaTest
@Import(WorldService::class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
internal class WorldServiceTest {

    @Autowired
    private lateinit var worldService: WorldService

    @Test
    internal fun `새 월드 추가`() {
        val world = createOneWorld()


        val dbWorld = worldService.save(world)

        println(dbWorld.id)
        println(dbWorld.projectKey)
        println(dbWorld.name)
        println(dbWorld.description)

        assertThat(dbWorld.id).isNotNull
        assertThat(dbWorld.projectKey).isEqualTo("io.homo_efficio.zepeto.world-1")
        assertThat(dbWorld.name).isEqualTo("체육관 월드")
        assertThat(dbWorld.description).isEqualTo("운동충 모여 노는 월드")
        assertThat(dbWorld.devPolicyAgree).isEqualTo(true)
    }

    private fun createOneWorld(): World {
        return World(
            "io.homo_efficio.zepeto.world-1",
            "체육관 월드",
            "운동충 모여 노는 월드",
            true
        )
    }
}
