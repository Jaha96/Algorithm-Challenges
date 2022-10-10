import java.util.HashSet;

public class ContainsDuplicateII {
    public static void main(String[] args){
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }


    /*
     * 219. Contains Duplicate II
     * Given an integer array nums and an integer k, 
     * return true if there are two distinct indices i and j in the array 
     * such that nums[i] == nums[j] and abs(i - j) <= k.
     * 
     * Input: nums = [1,2,3,1], k = 3
        Output: true
     */
    // 2022.10.04 Japar
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if(nums == null || nums.length < 1)
            return false;
        
        HashSet<Integer> set = new HashSet<>();
        int removeIndex = 0;
        for(int i=0; i<nums.length; i++){
            
            
            removeIndex = i - (k+1);
            if(removeIndex >=0)
                set.remove(nums[removeIndex]);
            
            if(set.contains(nums[i]))
                return true;
            
            set.add(nums[i]);
            
        }
        
        return false;
    }
}
