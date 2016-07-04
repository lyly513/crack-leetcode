public class Solution {
    //solution 1 use hashset to store the nearest k indices
    //使用hashset和hashmap的区别在于hashmap是可以根据key取回value值，因为排序不会变化
    //但是hashset不能取回value，只能判断里面有没有key，因为排序会变化，所以只能用add来判断里面有没有key
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i-k-1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    //solution 2 use HashMap
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            if (i - map.get(nums[i]) <= k) {
                return true;
            }
        }
        map.put(nums[i], i);
    }
    return false;
    }


}