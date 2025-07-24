package manticorp.developer.game_api.models

import manticorp.developer.game_api.models.GameConfig.GameChoices

data class GameTurnRequest(val turnNumber: Number, val userSelection: GameChoices)

data class GameTurnResponse(val turnNumber: Number, val gameResult: GameResult, val serverSelection: String) {
    enum class GameResult() {
        Winner,
        Loser,
        Tie;
    }
}