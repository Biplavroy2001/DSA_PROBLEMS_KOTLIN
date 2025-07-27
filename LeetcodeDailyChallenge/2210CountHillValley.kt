class Solution2210{
    fun countHillValley(nums: IntArray): Int {
        var count = 0
        var left = 0
        
        for (i in 1 until nums.size - 1) {
            if (nums[i] != nums[i + 1]) {
                if ((nums[i] > nums[left] && nums[i] > nums[i + 1]) || 
                    (nums[i] < nums[left] && nums[i] < nums[i + 1])) {
                    count++
                }
                left = i
            }
        }
        return count
    }
}

fun main() {
    val solution = Solution2210()
    
 
    val nums1 = intArrayOf(2, 4, 1, 1, 6, 5)
    println(solution.countHillValley(nums1)) // Expected output: 3
    
    
}