// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Similar to minimum falling path sum, at each element, choose you are goint ot take it's 2 neighbors in the next level or not
// We choose element that contibutes to min falling sum. Resut is minimum value in last row
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i=1;i<n;i++)//triangle rows
        {
            for(int j=0;j<i+1;j++)//triangle cols
            {
                //check prev row
                if(j==0){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(0));
                }
                else if(j==i)
                {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                }
                else{
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res, triangle.get(n-1).get(i));
        }
        return res;
    }
}