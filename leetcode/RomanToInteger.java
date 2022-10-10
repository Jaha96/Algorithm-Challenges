import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args){
        romanToInt("III");
        romanToInt("XXVII");
        romanToInt("LVIII");
        romanToInt("MCMXCIV");
        romanToInt("MDCCCLXXXIV"); //1884
    }

    public static int romanToInt(String s) {
        System.out.println(s);
        HashMap<String, Integer> romanTable = new HashMap<>();
        romanTable.put("I", 1);
        romanTable.put("V", 5);
        romanTable.put("X", 10);
        romanTable.put("L", 50);
        romanTable.put("C", 100);
        romanTable.put("D", 500);
        romanTable.put("M", 1000);
        romanTable.put("IV", 4);
        romanTable.put("IX", 9);
        romanTable.put("XL", 40);
        romanTable.put("XC", 90);
        romanTable.put("CD", 400);
        romanTable.put("CM", 900);

        int sum = 0;
        String prevChar = null;
        for(int i=0; i<s.length(); i++){
            if(prevChar == null && (s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C')){
                prevChar = String.valueOf((s.charAt(i)));
            } else{
                if(prevChar != null && romanTable.containsKey(prevChar + s.charAt(i))){
                    sum += romanTable.get(prevChar + s.charAt(i));
                    prevChar = null;
                } else if(prevChar == null){
                    sum += romanTable.get(String.valueOf(s.charAt(i)));
                } else{
                    sum += romanTable.get(prevChar);
                    prevChar = null;
                    i--;
                }
            }
        }
        if(prevChar != null)
            sum += romanTable.get(prevChar);
        System.out.println(sum);
        return sum;
    }
}
