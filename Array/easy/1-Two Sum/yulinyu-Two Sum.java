import java.util.Hashtable;
public class Solution {
    //use hashtable
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Hashtable<Integer, Integer> nums = new Hashtable<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            // put number into hash table (if it's not already there),这是处理有重复的情况
            Integer n = nums.get(numbers[i]);
            if (n == null)
                nums.put(numbers[i], i); // subtract array element from target
                                            // number
            n = nums.get(target - numbers[i]);
            if (n != null && n < i) {// if such number exists in the table
                                        // return the indices
                result[0] = n;
                result[1] = i;
                return result;
            }
        }
        return result;
    }

    //use HashMap
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]);
                result[1] = i;
            } else {
                map.put(numbers[i], i);
            }
        }
        return result;
    }

    //排序+two pointer
    public int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
             return result;
         }
        int[] numscopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numscopy);
        int start = 0;
        int end = numscopy.length - 1;
        while(start <= end) {
            if (numscopy[start] + numscopy[end] == target) {
                break;
            } else if (numscopy[start] + numscopy[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == numscopy[start] && flag == 0) {
                result[0] = i;
                flag = 1;
            }
            if (nums[i] == numscopy[end]) {
                result[1] = i;
            }
        }
        return result;
    }

}