import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
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
    public int[] topKFrequent_backup1(int[] nums, int k) {
        
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

    // 2022.10.10 
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums)    map.put(i, map.getOrDefault(i, 0) + 1);
        
        List<Integer>[] freq = new List[nums.length + 1];
        for(int key: map.keySet()) {
            int value = map.get(key);
            if(freq[value] == null)
                freq[value] = new LinkedList<>();
            freq[value].add(key);
        }  
        
        int[] result = new int[k];
        int j=0;
        for(int i=nums.length; i>0; i--){
            if(freq[i] != null) {
                List<Integer> list = freq[i];
                for(Integer val: list){
                    result[j++] = val;
                    if(j==k) return result;
                }
                
            }
        }
        return result;
    }
}
