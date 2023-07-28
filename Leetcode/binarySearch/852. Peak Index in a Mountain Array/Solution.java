//T(n)=O(logn)

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int st = 0, end = arr.length - 1;
        int ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] < arr[mid + 1]) {
                ans = mid + 1; // Update the answer to the index of the next element
                st = mid + 1; // Move the start index to mid + 1
            } else {
                end = mid - 1; // Move the end index to mid - 1
            }
        }
        return ans; // Return the index of the peak element
    }
}
