package manticorp.developer.game_api.controllers

import io.swagger.v3.oas.annotations.Operation
import manticorp.developer.game_api.models.GameConfig
import manticorp.developer.game_api.models.GameTurnRequest
import manticorp.developer.game_api.models.GameTurnResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1")
class GameController {

    @Operation(summary = "Get game config", description = "Returns the game configuration")
    @GetMapping("/game-config")
    fun getConfig() = GameConfig()

    @Operation(summary = "Post turn", description = "Calculates the winner of the turn")
    @PostMapping("/game-turn")
    fun postTurn(@RequestBody gameTurnRequest: GameTurnRequest): GameTurnResponse {
        return try {
            val computerSelection = (1..3).random()

            if (gameTurnRequest.userSelection.value() === computerSelection) {
                GameTurnResponse(
                    gameTurnRequest.turnNumber,
                    gameResult = GameTurnResponse.GameResult.Tie,
                    GameConfig.GameChoice.getNameByValue(computerSelection),
                    userSelection = GameConfig.GameChoice.getNameByValue(gameTurnRequest.userSelection.value())
                )
            } else if (gameTurnRequest.userSelection.value() === 1 && computerSelection === 3) { // Rock beats scissors
                GameTurnResponse(
                    gameTurnRequest.turnNumber,
                    gameResult = GameTurnResponse.GameResult.Winner,
                    GameConfig.GameChoice.getNameByValue(computerSelection),
                    userSelection = GameConfig.GameChoice.getNameByValue(gameTurnRequest.userSelection.value())
                )
            } else if (gameTurnRequest.userSelection.value() === 2 && computerSelection === 1) { // Paper beats rock
                GameTurnResponse(
                    gameTurnRequest.turnNumber,
                    gameResult = GameTurnResponse.GameResult.Winner,
                    GameConfig.GameChoice.getNameByValue(computerSelection),
                    userSelection = GameConfig.GameChoice.getNameByValue(gameTurnRequest.userSelection.value())
                )
            } else if (gameTurnRequest.userSelection.value() === 3 && computerSelection === 2) { // Scissors beats paper
                GameTurnResponse(
                    gameTurnRequest.turnNumber,
                    gameResult = GameTurnResponse.GameResult.Winner,
                    GameConfig.GameChoice.getNameByValue(computerSelection),
                    userSelection = GameConfig.GameChoice.getNameByValue(gameTurnRequest.userSelection.value())
                )
            }
            else {
                GameTurnResponse(
                    gameTurnRequest.turnNumber,
                    gameResult = GameTurnResponse.GameResult.Loser,
                    GameConfig.GameChoice.getNameByValue(computerSelection),
                    userSelection = GameConfig.GameChoice.getNameByValue(gameTurnRequest.userSelection.value())
                )
            }
        } catch (e: Exception) {
            throw ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Invalid request: \${e.message}",
                e
            )
        }
    }
}