import java.util.Arrays;

public class TwoSum2Sorted {

    public static void main(String[] args){
        System.out.println("Hello world");
        TwoSum2Sorted twoSum = new TwoSum2Sorted();
        System.out.println(twoSum.twoSumArray(new int[]{0,1,2,3,4}, 6));
    }

    public String twoSumArray(int[] numbers, int target){

        return Arrays.toString(twoSum(numbers, target));
    }

    // 2022.10.19 
    public int[] twoSum(int[] numbers, int target) {
        
        int left, right, query, middle;
        int n = numbers.length;
        
        for(int i=0; i<n; i++){
            query = target - numbers[i];
            left = i + 1;
            right = n - 1;
            
            while(left <= right){
                middle = left + (right - left) / 2;
                if(numbers[middle] == query)
                    return new int[]{i + 1, middle + 1};
                
                if(numbers[middle] < query) 
                    left = middle + 1;
                else    
                    right = middle - 1;
            }
        }
        
        return new int[]{};
    }
}
