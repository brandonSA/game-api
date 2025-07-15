package manticorp.developer.game_api.models

data class GameConfig (val numberOfGames: Number, val gameChoices: Array<GameChoices>) {
    enum class GameChoices {
        Rock, Paper, Scissors
    }
}

