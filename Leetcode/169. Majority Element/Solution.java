class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int count = 1;
        int first = nums[0];
        for(int i = 1; i<n; i++){
            if(count==0)
                first = nums[i];
            if(nums[i]==first){
                count++;
            }
            else{
                count--;
            }
        }
        return first;
    }
}