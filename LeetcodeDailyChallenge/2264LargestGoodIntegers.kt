class Solution2264{
    fun largestGoodInteger(num: String): String {
        var maxGood = ""
        for (i in 0..num.length - 3) {
            val current = num.substring(i, i + 3)
            if (current[0] == current[1] && current[1] == current[2]) {
                if (maxGood.isEmpty() || current > maxGood) {
                    maxGood = current
                }
            }
        }
        return maxGood
    }
}

fun main() {
    val solution = Solution2264()
    
    // Test Case 1
    val num1 = "6777133339"
    println("Input: $num1")
    println("Output: ${solution.largestGoodInteger(num1)}")  // Expected: "777"
    
}