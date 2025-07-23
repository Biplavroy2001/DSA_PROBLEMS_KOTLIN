fun main() {
    val solution = Solution1717()

    // Test Case 1
    val s1 = "cdbcbbaaabab"
    val x1 = 4
    val y1 = 5
    println(solution.maximumGain(s1, x1, y1)) // Expected output: 19

   
}

class Solution1717 {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        var totalPoints = 0
        val (highPriorityPair, lowPriorityPair) = if (x > y) Pair("ab", "ba") else Pair("ba", "ab")
        val (highPriorityScore, lowPriorityScore) = if (x > y) Pair(x, y) else Pair(y, x)

        // First pass for the higher score
        val afterFirstPass = solve(s, highPriorityPair, highPriorityScore)
        totalPoints += afterFirstPass.points

        // Second pass for the lower score on the remaining string
        val afterSecondPass = solve(afterFirstPass.remainingString, lowPriorityPair, lowPriorityScore)
        totalPoints += afterSecondPass.points

        return totalPoints
    }

    private fun solve(text: String, pattern: String, score: Int): Result {
        val stack = StringBuilder()
        var points = 0
        val p1 = pattern[0]
        val p2 = pattern[1]

        for (currentChar in text) {
            if (stack.isNotEmpty() && stack.last() == p1 && currentChar == p2) {
                stack.deleteCharAt(stack.length - 1)
                points += score
            } else {
                stack.append(currentChar)
            }
        }
        return Result(points, stack.toString())
    }

    // Data class to return multiple values from the solve function
    private data class Result(val points: Int, val remainingString: String)
}