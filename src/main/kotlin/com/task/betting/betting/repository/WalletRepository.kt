package com.task.betting.betting.repository

import com.task.betting.betting.model.Wallet
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono


interface WalletRepository : ReactiveCrudRepository<Wallet, Int> {

    fun findByPlayerId(playerId: Int): Mono<Wallet>

    //fun createWallet(wallet: Wallet): Mono<Wallet>
}