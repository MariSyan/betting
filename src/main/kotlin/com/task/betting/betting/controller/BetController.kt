import com.task.betting.betting.model.Bet
import com.task.betting.betting.model.BetRequest
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/bets")
class BetController(private val betService: BetService) {

    @PostMapping("/{playerId}/place")
    fun placeBet(@PathVariable playerId: Int, @RequestBody request: BetRequest): Mono<Bet> {
        return betService.placeBet(playerId, request.betAmount, request.betNumber)
    }

    @GetMapping("/{playerId}/bets")
    fun getPlayerBets(@PathVariable playerId: Long): Flux<Bet> {
        return betService.getPlayerBets(playerId)
    }
}
