package me.zepeto.creator.in_app_game.creator.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class World(
    val projectKey: String,
    var name: String,
    var description: String,
    val devPolicyAgree: Boolean
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
