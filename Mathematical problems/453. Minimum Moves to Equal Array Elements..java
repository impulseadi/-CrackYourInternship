class Solution {
    public int minMoves(int[] nums) {
          int min=0;
    Arrays.sort(nums);
    for(int i=nums.length-1;i>=0;i--){
        min+=nums[i]-nums[0];
    }
    return min;
    }
}
