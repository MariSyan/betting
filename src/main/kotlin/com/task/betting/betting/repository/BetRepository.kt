package com.task.betting.betting.repository

import com.task.betting.betting.model.Bet

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux


interface BetRepository : ReactiveCrudRepository<Bet, Long> {
    fun findByPlayerId(playerId: Long): Flux<Bet>
}