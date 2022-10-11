import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args){
        ProductOfArrayExceptSelf program = new ProductOfArrayExceptSelf();
        System.out.println(program.productExceptSelf(new int[]{1,2,3,4}));
    }


    // 2022.10.11 Prefix sum, Postfix sum
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        
        int preFix = 1;
        for(int i=0; i<nums.length; i++){
            res[i] = preFix;
            preFix *= nums[i];
        }
        int postFix = 1;
        for(int i=nums.length-1; i>=0;i--){
            res[i] *= postFix;
            postFix *= nums[i];
        }
        
        return res;
    }
}
