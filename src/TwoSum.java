import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};
        int[] result = twoSum_hashmap_version(nums, 9);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target){
        for(int i=0; i<nums.length - 1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum_hashmap_version(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int remainder = target - nums[i];
            if(map.containsKey(remainder)) {
                return new int[]{i, map.get(remainder)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
