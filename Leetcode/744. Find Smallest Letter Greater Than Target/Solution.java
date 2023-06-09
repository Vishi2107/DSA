class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;                          // Start index of the array
        int end = letters.length - 1;           // End index of the array
        char result = 'a';                      // Default value for the result

        while (start <= end) {                  // Perform binary search until start and end indices cross each other
            int mid = start + (end - start) / 2; // Calculate the middle index
            if (target < letters[mid]) {        // If the target is less than the letter at the middle index
                result = letters[mid];          // Update the result with the current letter
                end = mid - 1;                  // Update the end index to search the left half
            } else {
                start = mid + 1;                // Update the start index to search the right half
            }
        }
        if (result <= target) {
            return letters[0];                  // If the result is less than or equal to the target, return the first letter of the array
        }
        return result;                          // Otherwise, return the result as the next greatest letter
    }
}


// #second solution

// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         int start = 0;                          // Start index of the array
//         int end = letters.length - 1;           // End index of the array
//         char result = 'a';                      // Default value for the result

//         while (start <= end) {                  // Perform binary search until start and end indices cross each other
//             int mid = start + (end - start) / 2; // Calculate the middle index

//             if (target < letters[mid]) {        // If the target is less than the letter at the middle index
//                 end = mid - 1;                  // Update the end index to search the left half
//             } else {
//                 start = mid + 1;                // Update the start index to search the right half
//             }
//         }

//         if (result <= target) {
//             return letters[0];                  // If the result is less than or equal to the target, return the first letter of the array
//         }
//         return letters[start % letters.length];  // Return the letter at the start index (next greatest letter)
//     }
// }
