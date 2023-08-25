class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index
            
            if (nums[mid] == target) {
                return true; // If the target is found at the middle index, return true
            }
            
            // Handle cases where the elements at low, mid, and high indices are the same
            else if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++; // Move low pointer rightward
                high--; // Move high pointer leftward
                continue; // Skip this iteration and proceed to the next one
            }
            
            else if (nums[low] <= nums[mid]) { // Check if the left half is sorted
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1; // If the target is within the left sorted portion, narrow the search to the left
                } else {
                    low = mid + 1; // Otherwise, search the right side
                }
            } else { // Right half is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1; // If the target is within the right sorted portion, narrow the search to the right
                } else {
                    high = mid - 1; // Otherwise, search the left side
                }
            }
        }
        
        return false; // If the target is not found in the array, return false
    }
}
