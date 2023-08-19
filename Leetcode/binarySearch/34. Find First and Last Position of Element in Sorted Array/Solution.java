class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Create an array to store the starting and ending indices of the target value
        int[] ans = new int[2];
        
        // Find the index of the first occurrence of the target value
        ans[0] = firstOcc(nums, target);
        
        // Find the index of the last occurrence of the target value
        ans[1] = lastOcc(nums, target);
        
        // Return the array containing the starting and ending indices
        return ans;
    }
    
    // Function to find the index of the first occurrence of the target value
    public static int firstOcc(int[] nums, int target) {
        int n = nums.length;
        int st = 0, end = n - 1;
        int first = -1; // Initialize the index of the first occurrence
        
        // Binary search loop
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                // Update the first occurrence index and search to the left
                first = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        // Return the index of the first occurrence (or -1 if not found)
        return first;
    }
    
    // Function to find the index of the last occurrence of the target value
    public static int lastOcc(int[] nums, int target) {
        int n = nums.length;
        int st = 0, end = n - 1;
        int last = -1; // Initialize the index of the last occurrence
        
        // Binary search loop
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                // Update the last occurrence index and search to the right
                last = mid;
                st = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        
        // Return the index of the last occurrence (or -1 if not found)
        return last;
    }
}
