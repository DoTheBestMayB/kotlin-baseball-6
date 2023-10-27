package baseball

import baseball.data.GameNumDeck
import baseball.data.InputType
import camp.nextstep.edu.missionutils.Console

class IOHandler {

    private val validInputAfterGame = listOf("1", "2")
    private val validInputWhileGame = (GameNumDeck.ALLOWED_MIN_NUM..GameNumDeck.ALLOWED_MAX_NUM).map {
        ASCII_ZERO + it
    }

    fun getInput(inputType: InputType): String {
        val input = Console.readLine()

        if (checkInputValid(input, inputType).not()) {
            throw IllegalArgumentException()
        }
        return input
    }

    fun show(msg: String) = print(msg)

    private fun checkInputValid(input: String, inputType: InputType): Boolean {
        return when (inputType) {
            InputType.WHILE_GAME -> checkInputValidWhileGame(input)
            InputType.AFTER_GAME -> checkInputValidAfterGame(input)
        }
    }

    private fun checkInputValidWhileGame(input: String): Boolean {
        if (input.length != ALLOWED_LENGTH_OF_INPUT) {
            return false
        }

        val countOfUniqueNum = input.filter {
            it in validInputWhileGame
        }.toSet().size

        return countOfUniqueNum == GameNumDeck.DIGIT
    }

    private fun checkInputValidAfterGame(input: String) = input in validInputAfterGame

    companion object {
        private const val ASCII_ZERO = '0'
        private const val ALLOWED_LENGTH_OF_INPUT = 3
    }
}