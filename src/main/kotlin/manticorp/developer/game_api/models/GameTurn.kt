package manticorp.developer.game_api.models

import manticorp.developer.game_api.models.GameConfig.GameChoice

data class GameTurnRequest(val turnNumber: Number, val userSelection: GameChoice)

data class GameTurnResponse(val turnNumber: Number, val gameResult: GameResult, val serverSelection: String, val userSelection: String) {
    enum class GameResult() {
        Winner,
        Loser,
        Tie;
    }
}