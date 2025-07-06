// NeetCode.io Array & Hashing Problem 2 Solution in Kotlin
// Problem: Valid Anagram
// Problem Statement:
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

// Examples:

// text
// Input: s = "anagram", t = "nagaram"
// Output: true

// Input: s = "rat", t = "car"
// Output: false
// Approaches
// Approach 1: Sorting
// Sort both strings

// Compare the sorted strings

// If they are equal → anagram

// Else → not anagram

// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(n) (or O(1) if we can modify input strings)

// Approach 2: Hash Map (Optimal)
// Check if lengths are different → if yes, immediately return false

// Create a frequency count array (size 26 for English letters)

// Increment count for each character in s

// Decrement count for each character in t

// If all counts are zero → anagram

// Else → not anagram

// Time Complexity: O(n)
// Space Complexity: O(1) (fixed size array)




// Function to check if two strings are anagrams
fun isAnagram(s: String, t: String): Boolean {
    // Early exit optimization: if lengths are different, they can't be anagrams
    if (s.length != t.length) return false
    
    // Create an integer array of size 26 (for each lowercase English letter)
    // Initialized to all zeros by default in Kotlin
    val charCounts = IntArray(26)
    
    // Loop through each character position in both strings
    // Since we've already checked lengths, we can safely use either string's indices
    for (i in s.indices) {
        // For character in string s:
        // - 'a' is subtracted to get a 0-based index (a=0, b=1, ..., z=25)
        // - Increment the count for this character
        charCounts[s[i] - 'a']++
        
        // For character in string t:
        // - Similarly get 0-based index
        // - Decrement the count for this character
        charCounts[t[i] - 'a']--
    }
    
    // After processing all characters:
    // If strings are anagrams, all counts should be zero (increments and decrements cancel out)
    for (count in charCounts) {
        // If any count is not zero, strings are not anagrams
        if (count != 0) {
            return false
        }
    }
    
    // All counts are zero - strings are anagrams
    return true
}

// Main function to test the isAnagram function
fun main() {
    // Test case 1: Valid anagram
    println(isAnagram("anagram", "nagaram")) // Output: true
    
    // Test case 2: Not an anagram (different letters)
    println(isAnagram("rat", "car"))         // Output: false
    
    // Test case 3: Valid anagram
    println(isAnagram("listen", "silent"))   // Output: true
    
    // Test case 4: Not an anagram
    println(isAnagram("hello", "world"))     // Output: false
}




// Live Example Walkthrough
// Let's take s = "anagram", t = "nagaram":

// Length check: both are 7 characters → continue

// Initialize charCounts as [0, 0, 0, ..., 0] (26 zeros)

// Process each character position:

// i=0: s[0]='a' (0), t[0]='n' (13)

// charCounts[0]++ → [1, 0, 0, ..., 0]

// charCounts[13]-- → [1, 0, 0, ..., -1, 0, ..., 0]

// i=1: s[1]='n' (13), t[1]='a' (0)

// charCounts[13]++ → [1, 0, 0, ..., 0, 0, ..., 0]

// charCounts[0]-- → [0, 0, 0, ..., 0, 0, ..., 0]

// Continue for all characters...

// After all characters processed, all counts are 0 → return true

// This solution efficiently checks for anagrams by using a fixed-size array to track character counts, providing optimal O(n) time complexity and O(1) space complexity.



