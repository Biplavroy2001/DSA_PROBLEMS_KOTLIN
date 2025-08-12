class Solution2787{
    fun numberOfWays(n: Int, x: Int): Int {
        val MOD = 1_000_000_007
        val dp = LongArray(n + 1).apply { this[0] = 1 }
        
        var i = 1
        while (true) {
            val power = i.toDouble().pow(x).toInt()
            if (power > n) break
            
            for (sum in n downTo power) {
                dp[sum] = (dp[sum] + dp[sum - power]) % MOD
            }
            i++
        }
        
        return dp[n].toInt()
    }
}

fun main() {
    val solution = Solution2787()
    
    println(solution.numberOfWays(10, 2))  // Output: 1
    println(solution.numberOfWays(4, 1))   // Output: 2
    

}