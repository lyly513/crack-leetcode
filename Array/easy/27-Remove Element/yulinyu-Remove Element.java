public class Solution {
    // use two pointer
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int walk = 0; walk < nums.length; walk++) {
            if(nums[walk] != val) {
                nums[index++] = nums[walk];
            }
        }
        return index;
    }

    //把后面的元素调到前面来,注意返回的是end+1，然后还要判断当start=end的情况
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            if(nums[start] == val) {
                if (nums[end] == val) {
                    end--;
                }else {
                    nums[start++] = nums[end--];
                }
            } else {
                start++;
            }
        }
        return end+1;
    }
}