fun main() {
    val solution = Solution3136()

    val testCases = listOf(
        "234Adas",   // true
        "b3",        // false
        "a3\$e",     // false
        "AE1r",      // true
        "12abc",     // true
        "1@a",       // false
        "abc",       // true
        "123",       // false
        "a1b",       // true
        "a@"         // false
    )

    for (word in testCases) {
        println("Input: \"$word\" -> Output: ${solution.isValid(word)}")
    }
}



class Solution3136 {
    fun isValid(word: String): Boolean {
        if (word.length < 3) return false

        var vowels = 0
        var consonants = 0

        for (c in word) {
            if (c.isLetter()) {
                if (c.lowercaseChar() in "aeiou") {
                    vowels++
                } else {
                    consonants++
                }
            } else if (!c.isDigit()) {
                return false
            }
        }
        return vowels >= 1 && consonants >= 1
    }
}
