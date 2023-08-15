class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 2; i <= n; i++){
                String temp = "";
                int curr = 0;
                int count = 1;
                for(int j = 1; j < res.length(); j++){
                    if(res.charAt(curr) == res.charAt(j)){
                        count++;
                    }else{
                        temp += count;
                        temp += res.charAt(curr); 
                        curr = j;
                        count = 1;
                    }
                }
                temp += count;
                temp += res.charAt(curr);
                res = temp;
        }
        return res;
    }

}