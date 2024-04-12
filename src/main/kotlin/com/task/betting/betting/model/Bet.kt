package com.task.betting.betting.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("bet")
data class Bet(
        @Id val id: Long? = null,
        @Column("player_id") val playerId: Int,
        val betAmount: Int,
        val betNumber: Int,
        val generatedNumber: Int,
        val winnings: Int
)