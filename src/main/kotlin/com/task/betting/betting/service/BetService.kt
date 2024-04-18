import com.task.betting.betting.model.Bet
import com.task.betting.betting.repository.BetRepository
import com.task.betting.betting.repository.PlayerRepository
import com.task.betting.betting.repository.WalletRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BetService(private val playerRepository: PlayerRepository,
                 private val betRepository: BetRepository,
                 private val walletRepository: WalletRepository) {

    fun placeBet(playerId: Int, betAmount: Int, betNumber: Int): Mono<Bet> {
        return playerRepository.findById(playerId)
                .flatMap { player ->
                    walletRepository.findByPlayerId(playerId)
                            .flatMap { wallet ->
                                if (wallet.balance < betAmount) {
                                    return@flatMap Mono.error<Bet>(RuntimeException("Insufficient balance"))
                                } else {
                                    val generatedNumber = (1..10).random()
                                    val winnings = calculateWinnings(betNumber, generatedNumber, betAmount)
                                    val updatedBalance = wallet.balance - betAmount + winnings
                                    val updatedWallet = wallet.copy(balance = updatedBalance)
                                    walletRepository.save(updatedWallet)
                                            .then(betRepository.save(Bet(playerId = playerId, betAmount = betAmount,
                                                    betNumber = betNumber, generatedNumber = generatedNumber, winnings = winnings)))
                                }
                            }
                }
    }

    private fun calculateWinnings(playerBet: Int, generatedNumber: Int, betAmount: Int): Int {
        return when (Math.abs(playerBet - generatedNumber)) {
            0 -> betAmount * 10
            1 -> betAmount * 5
            2 -> betAmount / 2
            else -> 0
        }
    }

    fun getPlayerBets(playerId: Long): Flux<Bet> {
        return betRepository.findByPlayerId(playerId)
    }
}