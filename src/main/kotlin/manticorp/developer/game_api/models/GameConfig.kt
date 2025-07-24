package manticorp.developer.game_api.models

data class GameConfig (val numberOfGames: Number, val gameChoices: Array<GameChoices>) {
    constructor(): this(3, GameChoices.entries.toTypedArray())

    enum class GameChoices(val value: Int) {
        Rock(1),
        Paper(2),
        Scissors(3);

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

