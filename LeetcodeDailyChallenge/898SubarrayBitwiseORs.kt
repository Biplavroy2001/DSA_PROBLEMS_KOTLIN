class Solution898{
    fun subarrayBitwiseORs(arr: IntArray): Int {
        val resultOrs = mutableSetOf<Int>()
        var currentOrs = mutableSetOf<Int>()

        for (x in arr) {
            val nextOrs = mutableSetOf<Int>()
            nextOrs.add(x)
            
            for (y in currentOrs) {
                nextOrs.add(x or y)
            }
            
            resultOrs.addAll(nextOrs)
            currentOrs = nextOrs
        }

        return resultOrs.size
    }
}

fun main() {
    val solution = Solution898()
    
    // Test case 1
    val arr1 = intArrayOf(0)
    println(solution.subarrayBitwiseORs(arr1))  // Output: 1

   
}