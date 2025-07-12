
fun main() {
    val solution = Solution1900()

    // Test case 1
    val n1 = 11
    val firstPlayer1 = 2
    val secondPlayer1 = 4
    val result1 = solution.earliestAndLatest(n1, firstPlayer1, secondPlayer1)
    println("Input: n = $n1, firstPlayer = $firstPlayer1, secondPlayer = $secondPlayer1")
    println("Output: [${result1[0]}, ${result1[1]}]")  // Expected: [3, 4]

    // Test case 2
    val n2 = 5
    val firstPlayer2 = 1
    val secondPlayer2 = 5
    val result2 = solution.earliestAndLatest(n2, firstPlayer2, secondPlayer2)
    println("Input: n = $n2, firstPlayer = $firstPlayer2, secondPlayer = $secondPlayer2")
    println("Output: [${result2[0]}, ${result2[1]}]")  // Expected: [1, 1]
}


class Solution1900 {
    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        var left = minOf(firstPlayer, secondPlayer)
        var right = maxOf(firstPlayer, secondPlayer)

        if (left + right == n + 1) {
            return intArrayOf(1, 1)
        }

        if (n == 3 || n == 4) {
            return intArrayOf(2, 2)
        }

        if (left - 1 > n - right) {
            val temp = n + 1 - left
            left = n + 1 - right
            right = temp
        }

        val nextRound = (n + 1) / 2
        var minRound = n
        var maxRound = 1

        if (right * 2 <= n + 1) {
            val preLeft = left - 1
            val midGap = right - left - 1
            for (i in 0..preLeft) {
                for (j in 0..midGap) {
                    val (minRes, maxRes) = earliestAndLatest(nextRound, i + 1, i + j + 2)
                    minRound = minOf(minRound, 1 + minRes)
                    maxRound = maxOf(maxRound, 1 + maxRes)
                }
            }
        } else {
            val mirrored = n + 1 - right
            val preLeft = left - 1
            val midGap = mirrored - left - 1
            val innerGap = right - mirrored - 1
            for (i in 0..preLeft) {
                for (j in 0..midGap) {
                    val (minRes, maxRes) = earliestAndLatest(
                        nextRound,
                        i + 1,
                        i + j + 2 + (innerGap + 1) / 2
                    )
                    minRound = minOf(minRound, 1 + minRes)
                    maxRound = maxOf(maxRound, 1 + maxRes)
                }
            }
        }

        return intArrayOf(minRound, maxRound)
    }
}
