package com.task.betting.betting.controller

import com.task.betting.betting.model.Player
import com.task.betting.betting.model.PlayerRegistrationRequest
import com.task.betting.betting.model.Wallet
import com.task.betting.betting.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/players")
class PlayerController(private val playerService: PlayerService) {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerPlayer(@RequestBody request: PlayerRegistrationRequest): Mono<Player> {
        return playerService.registerPlayer(request.name, request.surname, request.username)
    }

    @GetMapping("/{playerId}/wallet")
    fun getPlayerWallet(@PathVariable playerId: Int): Mono<Wallet> {
        return playerService.getPlayerWallet(playerId)
    }

    @GetMapping("/leaderboard")
    fun getLeaderboard(count : Int): Flux<Player> {
        return playerService.getLeaderboard(count)
    }
}
