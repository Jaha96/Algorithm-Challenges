import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class ThreeSum {
    
    public static void main(String[] args){
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-2,0,1,1,2}));
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,0}));
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum.threeSum(new int[]{0,1,1}));
        System.out.println(threeSum.threeSum(new int[]{0,0,0}));
        System.out.println(threeSum.threeSum(new int[]{0,0,0,0}));
        
    }

    // 2022.10.27 //Did not pass duplicate triplet cases
    public List<List<Integer>> threeSum_backup1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 3)
            return result;
        
        int p1, p2;
        p1 = 0;
        p2 = p1 + 1;
        
        Set<Integer> set = new HashSet<>();
        
        while(p2 < nums.length){
            int temp = nums[p1] + nums[p2];
            int query = 0 - temp;
            
            if(set.contains(query))
                result.add(Arrays.asList(nums[p1] ,nums[p2], query));
            
            set.add(nums[p1]);
            p1++;
            p2++;
        }
        
        return result;
    }

    // 2022.11.01 // Did not pass [2,0,1,1,2], Output:[[-2,0,2]], Expected: [[-2,0,2],[-2,1,1]]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 3)
            return result;
        
        Arrays.sort(nums);
        
        int left, right, mid;
        int n = nums.length;
        
        
        int lastDigit = 0;
        
        for(int i=2; i<n; i++){
            if(i!=2 && lastDigit == nums[i])
                continue;
            int a = nums[i-2];
            int b = nums[i-1];
            int c = 0 - (a + b);
            
            left = i;
            right = n-1;
            
            while(left <= right){
                mid = (right - left) / 2 + left;

                if(nums[mid] == c){
                    result.add(Arrays.asList(a,b,c));
                    break;
                } else if(nums[mid] < c){
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
            lastDigit = nums[i];
        }
        return result;
    }
}
