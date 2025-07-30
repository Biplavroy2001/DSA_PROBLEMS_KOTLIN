// Contains Duplicate Problem Solution in Kotlin
// Problem Statement (from NeetCode.io)
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: true

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

// Approaches to Solve the Problem
// Approach 1: Brute Force (Not Optimized)
// Compare each element with every other element in the array

// Time Complexity: O(n²) - Not efficient for large arrays

// Space Complexity: O(1) - No extra space needed

// Approach 2: Sorting (Better)
// Sort the array first

// Then check adjacent elements for duplicates

// Time Complexity: O(n log n) - Due to sorting

// Space Complexity: O(1) - If sorting in place

// Approach 3: Hash Set (Optimal)
// Use a hash set to track seen elements

// If an element is already in the set, return true

// Time Complexity: O(n) - Single pass through array

// Space Complexity: O(n) - Need to store elements in set

// We'll implement the optimal Approach 3 using Hash Set.





/**
 * Checks if the given integer array contains any duplicate values.
 * 
 * @param nums The input array of integers to check for duplicates
 * @return true if any value appears at least twice, false otherwise
 */

fun containsDuplicate(nums: IntArray): Boolean {
    // Create a hash set to store the numbers we've seen so far
    // HashSet provides O(1) average time complexity for add and contains operations
    val seenNumbers = HashSet<Int>()

    // Iterate through each number in the input array
    for (num in nums) {
        // Check if the current number is already in our set
        if (num in seenNumbers) {
            // If it is, we've found a duplicate - return true immediately
            return true
        }
        // If not, add it to our set of seen numbers
        seenNumbers.add(num)
    }

    // If we've gone through the entire array without finding duplicates, return false
    return false
}


/**
 * Main function to test the containsDuplicate function with various test cases.
 */
fun main() {
    // Test case 1: Array with duplicates
    val nums1 = intArrayOf(1, 2, 3, 1)
    println("Test case 1: ${containsDuplicate(nums1)}") // Expected output: true

    // Test case 2: Array without duplicates
    val nums2 = intArrayOf(1, 2, 3, 4)
    println("Test case 2: ${containsDuplicate(nums2)}") // Expected output: false

    // Test case 3: Large array with multiple duplicates
    val nums3 = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
    println("Test case 3: ${containsDuplicate(nums3)}") // Expected output: true

    // Test case 4: Empty array
    val nums4 = intArrayOf()
    println("Test case 4: ${containsDuplicate(nums4)}") // Expected output: false

    // Test case 5: Single element array
    val nums5 = intArrayOf(1)
    println("Test case 5: ${containsDuplicate(nums5)}") // Expected output: false
}








// Detailed Explanation of the Solution
// Function Definition
// kotlin
// fun containsDuplicate(nums: IntArray): Boolean {
// This defines a function named containsDuplicate that takes an IntArray (integer array) as input and returns a Boolean value.

// HashSet Initialization
// kotlin
// val seenNumbers = HashSet<Int>()
// Creates an empty HashSet to keep track of numbers we've already seen in the array.

// HashSet is chosen because it provides O(1) average time complexity for both insertion and lookup operations.

// Iterating Through the Array
// kotlin
// for (num in nums) {
// This starts a loop that goes through each element (num) in the input array (nums).

// Checking for Duplicates
// kotlin
// if (num in seenNumbers) {
//     return true
// }
// For each number, we check if it already exists in our seenNumbers set.

// The in keyword in Kotlin checks for membership in a collection.

// If the number is found in the set, it means we've encountered a duplicate, so we immediately return true.

// Adding New Numbers to the Set
// kotlin
// seenNumbers.add(num)
// If the number is not in the set, we add it to the set so we can check for duplicates in future iterations.

// Final Return
// kotlin
// return false
// If we finish the loop without finding any duplicates, we return false indicating all elements are unique.

// Main Function
// The main function tests our containsDuplicate function with several test cases:

// Array with duplicates at beginning and end

// Array with all unique elements

// Large array with multiple duplicates

// Empty array (edge case)

// Single element array (edge case)