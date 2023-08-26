class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        // Base cases
        if (n == 1) return nums[0]; // If array has only one element, it's the answer
        if (nums[0] != nums[1]) return nums[0]; // If the first element is unique, it's the answer
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1]; // If the last element is unique, it's the answer

        int low = 1, high = n - 2; // Initialize the search range excluding the first and last elements
        
        // Binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index
            
            // Check if nums[mid] is the single non-duplicate element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid]; // Return the single non-duplicate element
            }
            
            // If we are on the left side and the mid element is repeated with the previous element
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1; // Move to the right side to find the single non-duplicate element
            }
            // If we are on the right side
            else {
                high = mid - 1; // Move to the left side to find the single non-duplicate element
            }
        }
        
        return -1; // If no single non-duplicate element is found (should not happen)
    }
}
