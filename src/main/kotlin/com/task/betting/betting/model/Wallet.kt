package com.task.betting.betting.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("wallet")
data class Wallet(
        @Id val id: Long? = null,
        @Column("player_id") val playerId: Int, // Specify the database column name
        val balance: Int
)
