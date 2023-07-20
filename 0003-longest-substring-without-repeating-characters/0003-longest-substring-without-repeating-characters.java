class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int res = 0;
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            while(l < i && set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(i));
            int len = i-l+1;
            res = Math.max(res, len);
        }
        return res;
    }
}