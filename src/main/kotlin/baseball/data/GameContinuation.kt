package baseball.data

enum class GameContinuation(val value: Int) {
    YES(1), NO(2);

    companion object {
        fun fromInt(value: Int): GameContinuation? = entries.firstOrNull { it.value == value }
    }
}