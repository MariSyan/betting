package com.task.betting.betting.service

import com.task.betting.betting.model.Wallet
import com.task.betting.betting.repository.WalletRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono



@Service
class WalletService(private val walletRepository: WalletRepository) {

    // Method to create a wallet for a player with an initial balance
    fun createWallet(playerId: Int, initialBalance: Int): Mono<Wallet> {
        // Create a new Wallet instance with null id (to be generated by the database), player ID, and initial balance
        val wallet = Wallet(id = null, playerId = playerId, balance = initialBalance)
        // Save the wallet to the database using the repository and return the result as a Mono
        return walletRepository.save(wallet)
    }
}
