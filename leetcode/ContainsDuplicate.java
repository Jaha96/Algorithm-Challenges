import java.util.HashSet;

/*
 * 
 * 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 * 
 */
public class ContainsDuplicate {

    // 2022.10.04 Japar
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i]))
                return true;
            
            set.add(nums[i]);
        }
        
        
        return false;
    }

    public static void main(String[] args){
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));

        System.out.println(containsDuplicate(new int[]{1,2,3,4}));

        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
