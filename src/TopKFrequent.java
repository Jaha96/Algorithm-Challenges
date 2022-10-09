import java.util.Map;
import java.util.HashMap;

public class TopKFrequent {
    public static void main(String[] args){
        TopKFrequent topK = new TopKFrequent();
        System.out.println(topK.topKFrequent(new int[]{1,2}, 2));
    }


    // 
    /*2022.10.09 Did not pass below case:
     * Input: [1,2]    2
     * Output: [2,0]
     * Expected: [1,2]
     */
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums)    map.put(i, map.getOrDefault(i, 0) + 1);
        
        Integer[] freq = new Integer[nums.length + 1];
        for(int key: map.keySet())  freq[map.get(key)] = key;
        
        int[] result = new int[k];
        int j=0;
        for(int i=nums.length; i>0; i--){
            if(freq[i] != null) {
                result[j++] = freq[i];
                if(j==k) return result;
            }
        }
        return result;
    }
}
