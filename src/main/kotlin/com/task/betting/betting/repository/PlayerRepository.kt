package com.task.betting.betting.repository

import com.task.betting.betting.model.Player
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface PlayerRepository : ReactiveCrudRepository<Player, Int> {
    fun findTopPlayersOrderByTotalWinnings(count: Int): Flux<Player>


}