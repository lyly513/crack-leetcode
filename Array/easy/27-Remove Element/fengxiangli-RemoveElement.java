public class Solution {
    public int removeElement(int[] nums, int val) {
        int current = 0;
        int left = 0;
        while(left<=nums.length - 1){
            if(nums[left] != val){
                nums[current++] = nums[left];
            }
            left ++ ;
        }
        return current;
    }
}
