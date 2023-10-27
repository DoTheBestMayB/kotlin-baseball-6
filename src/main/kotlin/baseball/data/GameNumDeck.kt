package baseball.data

import camp.nextstep.edu.missionutils.Randoms

data class GameNumDeck(
    val nums: List<Int>,
) {
    companion object {
        const val DIGIT = 3
        const val ALLOWED_MIN_NUM = 1
        const val ALLOWED_MAX_NUM = 9

        fun generateRandomDeck(): GameNumDeck {
            val tempNumSet = mutableSetOf<Int>()
            while (tempNumSet.size < DIGIT) {
                val randomNumber = Randoms.pickNumberInRange(ALLOWED_MIN_NUM, ALLOWED_MAX_NUM)
                tempNumSet.add(randomNumber)
            }
            return GameNumDeck(tempNumSet.toList())
        }
    }
}