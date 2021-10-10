package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0

    val secretMatchedAlready = BooleanArray(secret.length)
    val guessMatchedAlready = BooleanArray(secret.length)

    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            secretMatchedAlready[i] = true
            guessMatchedAlready[i] = true
            rightPosition++
        }
    }

    for (i in secret.indices) {
        for (j in secret.indices) {
            if (!guessMatchedAlready[i] && !secretMatchedAlready[j] && secret[j] == guess[i]) {
                secretMatchedAlready[j] = true
                wrongPosition++
                break
            }
        }
    }
    return Evaluation(rightPosition, wrongPosition)
}
