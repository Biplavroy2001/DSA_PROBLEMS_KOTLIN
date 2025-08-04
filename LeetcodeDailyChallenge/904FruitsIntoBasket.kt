class Solution904{
    fun totalFruit(fruits: IntArray): Int {
        var start = 0
        var end = 0
        var maxLen = 0
        val fruitCount = mutableMapOf<Int, Int>()
        
        while (end < fruits.size) {
            fruitCount[fruits[end]] = fruitCount.getOrDefault(fruits[end], 0) + 1
            
            while (fruitCount.size > 2) {
                fruitCount[fruits[start]] = fruitCount[fruits[start]]!! - 1
                if (fruitCount[fruits[start]] == 0) {
                    fruitCount.remove(fruits[start])
                }
                start++
            }
            
            maxLen = maxOf(maxLen, end - start + 1)
            end++
        }
        
        return maxLen
    }
}

fun main() {
    val solution = Solution904()

    // Test Case 1 (Example 1)
    val fruits1 = intArrayOf(1, 2, 1)
    println(solution.totalFruit(fruits1)) // Expected output: 3

}