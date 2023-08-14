class Solution {
    public String longestPalindrome(String s) {
        
                        System.out.println(s.length());
        int st = 0;
        int e = 0;
        int max = 0;
        // if(s.length() <= 1){return s;}
        for(int i = 0; i <= s.length(); i++){
            for(int j = i; j <= s.length(); j++){
                if(palindrom(s.substring(i, j))){
                    if(s.substring(i, j).length() >= max){
                        max = s.substring(i, j).length();
                        st = i;
                        e = j;
                    }
                }
            }
        }
        return s.substring(st,e);
    }
    boolean palindrom(String s){
        int st = 0;
        int e = s.length()-1;
        while(st < e){
            if(s.charAt(st) != s.charAt(e)){
                return false;
            }
            st++;
            e--;
        }
        return true;
    }
 
}