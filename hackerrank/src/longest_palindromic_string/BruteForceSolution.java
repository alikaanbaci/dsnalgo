package longest_palindromic_string;

public class BruteForceSolution {
    public String longestPalindrome(String s) {
        String max = "";
        String searching = "";
        int size = s.length();

        for(int i = 0; i < size; i++) {
            for(int j = i; j<size; j++) {
                searching = s.substring(i, j+1);
                if(isPalindrome(searching)) {
                    if(max.length() < searching.length()) {
                        max = searching;
                    }
                }
            }
        }

        return max;
    }

    public Boolean isPalindrome(String s) {

        int size = s.length();

        if(size == 1) return true;

        for(int i = 0; i < size/2; i++) {
            if(s.charAt(i) != s.charAt(size-1-i)) {
                return false;
            }
        }

        return true;
    }
}
