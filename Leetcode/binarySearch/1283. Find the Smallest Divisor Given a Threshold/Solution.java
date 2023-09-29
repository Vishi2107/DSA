//Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

// The test cases are generated so that there will be an answer.

class Solution {
    // Helper function to calculate the summation of division values
    public int sumByD(int[] nums, int div) {
        int n = nums.length; // Size of the array
        int sum = 0;

        // Find the summation of division values
        for (int i = 0; i < n; i++) {
            // Calculate the division result and round up to the nearest integer using Math.ceil
            sum += Math.ceil((double)(nums[i]) / (double)(div));
        }
        return sum;
    }

    // Main function to find the smallest divisor
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        // If the length of the array is greater than the threshold, return -1 (no valid result)
        if (n > threshold)
            return -1;

        // Find the maximum element in the array
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int low = 1, high = maxi;

        // Perform binary search to find the smallest divisor
        while (low <= high) {
            int mid = (low + high) / 2;
            // Calculate the summation of division values using the helper function
            if (sumByD(nums, mid) <= threshold) {
                // If the sum is less than or equal to the threshold, update the high bound
                high = mid - 1;
            } else {
                // If the sum is greater than the threshold, update the low bound
                low = mid + 1;
            }
        }
        return low; // Return the smallest divisor
    }
}

