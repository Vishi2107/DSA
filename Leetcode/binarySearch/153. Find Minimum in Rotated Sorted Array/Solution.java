class Solution {
    public static int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE; // Initialize ans to a large value

        // Binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the middle index

            if (arr[low] <= arr[high]) { // If the array is sorted from low to high
                ans = Math.min(ans, arr[low]); // Update ans with the minimum value
                break; // Exit the loop
            }

            if (arr[low] <= arr[mid]) { // If the left part of the array is sorted
                ans = Math.min(ans, arr[low]); // Update ans with the minimum value
                low = mid + 1; // Update low to search in the right half
            } else { // If the right part of the array is sorted
                ans = Math.min(ans, arr[mid]); // Update ans with the minimum value
                high = mid - 1; // Update high to search in the left half
            }
        }
        return ans; // Return the minimum value found
    }
}
