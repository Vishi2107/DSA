class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;        // Length of the input array 'nums'
        int st = 0, end = n - 1;    // Pointers for binary search: start and end indices
        int ans = n;                // Default answer (index where target should be inserted)

        // Binary search loop
        while (st <= end) {
            int mid = st + (end - st) / 2;  // Calculate the midpoint for binary search

            if (nums[mid] >= target) {      // If the value at mid is greater than or equal to the target
                ans = mid;                  // Update the answer to the current mid index
                end = mid - 1;              // Move the 'end' pointer to explore the left half
            } else {
                st = mid + 1;               // Move the 'start' pointer to explore the right half
            }
        }

        return ans;  // Return the index where the target should be inserted
    }
}
