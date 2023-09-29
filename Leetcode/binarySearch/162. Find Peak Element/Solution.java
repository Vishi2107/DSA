//A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

// You must write an algorithm that runs in O(log n) time.

class Solution {
    public int findPeakElement(int[] nums) {
        // Get the length of the input array
        int n = nums.length;
        
        // Initialize low and high pointers for binary search
        int low = 1, high = n - 2; // Note: These indices are chosen to avoid out-of-bounds access
        
        // Special cases:
        // If the array is empty, return -1 (no peak)
        if (n == 0)
            return -1;
        
        // If the first element is greater than the second element, it's a peak
        if (nums[0] > nums[1])
            return 0;
        
        // If the last element is greater than the second-to-last element, it's a peak
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        // Perform binary search for a peak element
        while (low <= high) {
            // Calculate the middle index
            int mid = low + (high - low) / 2;

            // Check if the element at the middle index is greater than its neighbors
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                // Found a peak, return its index
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                // If the element at mid is greater than its left neighbor, move to the right half
                low = mid + 1;
            } else {
                // If the element at mid is less than or equal to its left neighbor, move to the left half
                high = mid - 1;
            }
        }
        
        // If no peak is found within the search boundaries, return -1
        return -1;
    }
}
