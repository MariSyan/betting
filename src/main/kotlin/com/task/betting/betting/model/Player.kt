package com.task.betting.betting.model


import jakarta.persistence.Id
import org.springframework.data.relational.core.mapping.Table


@Table("player")
data class Player(
        @Id val id: Long? = null,
        val name: String,
        val surname: String,
        val username: String,
        val totalWinnings: Long = 0
)



