// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : For each element, check if it can be added t previous element's slice. If yes add to number slices that can be
/// add it to prev elemnts slices+1. Lastly iterate though array and add elements in the array
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int curr=0, cnt = 0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                curr = curr+1;
            }
            else{
                curr = 0;
            }
            cnt+=curr;
        }
        return cnt;
    }
}