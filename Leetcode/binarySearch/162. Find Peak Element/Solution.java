//A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

// You must write an algorithm that runs in O(log n) time.

class Solution {
    public int findPeakElement(int[] nums) {
        // Initialize two pointers, 'start' and 'end', representing the start and end indices of the array.
        int start = 0;
        int end = nums.length - 1;

        // Perform binary search to find a peak element efficiently.
        while (start < end) {
            // Calculate the middle index 'mid' of the current range using binary search.
            int mid = start + (end - start) / 2;

            // Check if the element at the middle index 'mid' is greater than the element at 'mid+1'.
            // If true, it means the peak element should be somewhere in the left half of the array (including the element at 'mid').
            if (nums[mid] > nums[mid + 1]) {
                end = mid; // Update 'end' to narrow down the search to the left half of the array.
            } else {
                start = mid + 1; // Update 'start' to narrow down the search to the right half of the array (excluding the element at 'mid').
            }
            mid = start + (end - start) / 2;
        }

        // After the while loop finishes, 'start' will point to the index of a peak element in the array.
        return start; // Return 'start' as the result since it points to a peak element.
    }
}
