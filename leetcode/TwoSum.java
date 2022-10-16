import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
    }


    // 2022.10.07
    public static int[] twoSum_backup2(int[] nums, int target) {
        
        //<Integer, Integer>  = num[i], i
        HashMap<Integer, Integer> set = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int query = target - nums[i];
            if(set.containsKey(query)){
                return new int[]{i, set.get(query)};
            }
            set.put(nums[i], i);
        }

        return null;
    }

    public static int[] twoSum_backup1(int[] nums, int target){
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

    // 2022.10.17
    public static int[] twoSum(int[] nums, int target) {
        
        
        //value and index
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int query = target - nums[i];
            if(map.containsValue(query)) return new int[]{i, map.get(query)};
            
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
