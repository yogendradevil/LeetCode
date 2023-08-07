class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int start = 0;
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ' ' && start != -1){
                arr.add(s.substring(start, i));
                start = -1;
            }else if(s.charAt(i) != ' ' && start == -1){
                start = i;
            }else if(s.charAt(i) == ' ' && start == -1){
                start = -1;
            }
        }
        if(start != -1){
            arr.add(s.substring(start, s.length()));
        }
        s = "";
        for(int i = arr.size()-1; i >= 0; i--){
            if( i == 0 ){
                s += arr.get(i);
            }else{
            s += arr.get(i)+" ";
            }
        }
        return s;
    }
}

