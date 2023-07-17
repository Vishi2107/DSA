class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int st = 0, end = n * m - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            int midVal = matrix[mid / m][mid % m];

            if (midVal == target) {
                return true; // Target value found in the matrix
            } else if (target < midVal) {
                end = mid - 1; // Target is in the left half of the range
            } else {
                st = mid + 1; // Target is in the right half of the range
            }
        }
        
        return false; // Target value not found in the matrix
    }
}
