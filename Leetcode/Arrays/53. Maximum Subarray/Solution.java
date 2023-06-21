//T(n)= O(n)
//S(n)= O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize variables
        int sum = 0;               // Current sum of subarray
        int n = nums.length;       // Length of the input array
        int max = Integer.MIN_VALUE; // Maximum sum found so far (initialized to the smallest possible value)

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Add the current element to the sum
            sum += nums[i];

            // Update the maximum sum if the current sum is greater
            if (sum > max) {
                max = sum;
            }

            // If the current sum is negative, reset it to 0
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the maximum sum
        return max;
    }

    public static void main(String[] args) {
        // Create an array
        int[] nums = {-2, -3, 1, 4, -1, -2, 1, 5, -3};

        // Create an instance of the Solution class
        Solution s = new Solution();

        // Call the maxSubArray method and print the result
        System.out.println(s.maxSubArray(nums));
    }
}

//Better solution T(n)= O(n2)
// for (int i = 0; i < n; i++) {
//             int sum = 0;
//             for (int j = i; j < n; j++) {
//                 // current subarray = arr[i.....j]

//                 //add the current element arr[j]
//                 // to the sum i.e. sum of arr[i...j-1]
//                 sum += arr[j];

//                 maxi = Math.max(maxi, sum); // getting the maximum
//             }
//         }