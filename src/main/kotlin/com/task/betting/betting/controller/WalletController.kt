package com.task.betting.betting.controller

import com.task.betting.betting.model.Wallet
import com.task.betting.betting.service.WalletService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/wallets")
class WalletController(private val walletService: WalletService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createWallet(@RequestParam playerId: Int, @RequestParam initialBalance: Int): Mono<Wallet> {
        return walletService.createWallet(playerId, initialBalance)
    }
}
