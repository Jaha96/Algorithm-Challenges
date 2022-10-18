public class ValidPalindrome {
    public static void main(String[] args){
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
        System.out.println(validPalindrome.isPalindrome(""));
    }

    public boolean isPalindrome(String s) {
        int lowerCaseDiff = 'a' - 'A';
        String lowerCase = "";
        for(int i=0; i<s.length(); i++){
            
            if('a' <= s.charAt(i) && s.charAt(i) <= 'z')
                lowerCase += s.charAt(i);
            else if('0' <= s.charAt(i) && s.charAt(i) <= '9')
                lowerCase += s.charAt(i);
            else if('A' <= s.charAt(i) && s.charAt(i) <= 'Z')
                lowerCase += (char)(s.charAt(i) + lowerCaseDiff);
        }
        
        int left = 0;
        int right = lowerCase.length() - 1;
        while(left < right){
            if(lowerCase.charAt(left++) != lowerCase.charAt(right--))
                return false;
        }
        return true;
    }
}
