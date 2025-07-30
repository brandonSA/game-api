package manticorp.developer.game_api.models

import com.fasterxml.jackson.annotation.JsonValue

data class GameConfig (val numberOfGames: Number, val gameChoices: Array<GameChoice>) {
    constructor(): this(3, GameChoice.entries.toTypedArray())

    enum class GameChoice(val value: Int, val icon: String) {
        Rock(1, "rock.png"),
        Paper(2, "paper.png"),
        Scissors(3, "scissors.png️");

        fun value(): Int {
            return value
        }

        companion object {
            fun getNameByValue(value: Int): String {
                return values().firstOrNull { it.value == value }?.name ?: "Unknown"
            }
        }
    }
}

