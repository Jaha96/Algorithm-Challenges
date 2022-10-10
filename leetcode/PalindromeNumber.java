public class PalindromeNumber {
    public static void main(String[] args){
        System.out.println(isPalindrome(100));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int backwardX = 0;
        int orig_x = x;
        while (x / 10 != 0 || x%10 != 0) {
            backwardX = backwardX * 10 + (x % 10);
            x/=10;
        }
        return backwardX==orig_x;
    }
}
