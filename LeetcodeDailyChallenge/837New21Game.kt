class Solution837{
    fun new21Game(n: Int, k: Int, maxPts: Int): Double {
        if (k == 0 || n >= k + maxPts) {
            return 1.0
        }
        val dp = DoubleArray(n + 1)
        dp[0] = 1.0
        var windowSum = 1.0
        var result = 0.0
        for (i in 1..n) {
            dp[i] = windowSum / maxPts
            if (i < k) {
                windowSum += dp[i]
            } else {
                result += dp[i]
            }
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts]
            }
        }
        return result
    }
}

fun main() {
    val solution = Solution837()
    

    val n1 = 10
    val k1 = 1
    val maxPts1 = 10
    println("Input: n = $n1, k = $k1, maxPts = $maxPts1")
    println("Output: ${solution.new21Game(n1, k1, maxPts1)}")
    println("Expected: 1.00000")
    println()

}