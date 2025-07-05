// // 
// Problem Statement
// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Example 1:
// Input: nums = [1,2,3,1], k = 3
// Output: true
// Explanation: nums[0] == nums[3] and abs(0 - 3) = 3 <= k

// Example 2:
// Input: nums = [1,0,1,1], k = 1
// Output: true
// Explanation: nums[2] == nums[3] and abs(2 - 3) = 1 <= k

// Example 3:
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
// Explanation: All duplicates have index differences greater than 2

// Approach: Sliding Window with Hash Set
// Intuition
// We need to find if there are any duplicate elements within a window of size k+1 in the array. The sliding window approach is perfect for this because it allows us to efficiently maintain and check a set of elements within the current window.

// Algorithm
// Initialize a HashSet to keep track of elements in the current window.

// Iterate through the array:

// For each element, check if it exists in the HashSet (which would mean we found a duplicate within the window).

// If found, return true.

// If not, add the element to the HashSet.

// Maintain the window size:

// If the window size exceeds k, remove the oldest element (i-k-1 th element) from the HashSet.

// If no duplicates found after the entire iteration, return false.

// Time Complexity: O(n)
// We traverse the list containing n elements only once. Each lookup and insertion in the HashSet takes O(1) time on average.

// Space Complexity: O(min(n, k))
// The extra space required depends on the number of items stored in the HashSet, which is the size of the sliding window (min(n, k)).




fun main(){
    val nums = intArrayOf(1,2,3,1,2,3)
    val k = 3
    println(containsNearbyDuplicates(nums, k))
}


fun containsNearbyDuplicates(nums: IntArray, k: Int): Boolean {
    // Create a HashSet to store elements within the current window
    val window = HashSet<Int>()
    
    // Iterate through each element in the array
    for (i in nums.indices) {
        // Check if current element already exists in the window (duplicate found)
        if (window.contains(nums[i])) {
            return true
        }
        
        // Add current element to the window
        window.add(nums[i])
        
        // If window size exceeds k, remove the oldest element (i-k th element)
        if (window.size > k) {
            window.remove(nums[i - k])
        }
    }
    
    // If no duplicates found within any window of size k, return false
    return false
}