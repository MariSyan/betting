package com.task.betting.betting.service

import com.task.betting.betting.model.Player
import com.task.betting.betting.model.Wallet
import com.task.betting.betting.repository.PlayerRepository
import com.task.betting.betting.repository.WalletRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PlayerService(private val playerRepository: PlayerRepository,
                    private val walletRepository: WalletRepository) {

    fun registerPlayer(name: String, surname: String, username: String): Mono<Player> {
        val wallet = Wallet(playerId = 0, balance = 1000)
        return walletRepository.save(wallet)
                .flatMap { savedWallet ->
                    val player = Player(name = name, surname = surname, username = username)
                    playerRepository.save(player.copy(id = null))
                }
    }

    fun getPlayerWallet(player_id: Int): Mono<Wallet> {
        return walletRepository.findByPlayerId(player_id)
    }

    fun getLeaderboard(count: Int): Flux<Player> {
        return playerRepository.findTopPlayersOrderByTotalWinnings(count)
    }
}