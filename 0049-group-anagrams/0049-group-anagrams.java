// extream noob level brute force approach

// class Solution {
//     public List<List<String>> groupAnagrams(String[] arr) {
//         List<List<String>> list = new ArrayList<>();
//         for(int i = 0; i < arr.length; i++){
//             int[] ref = new int[26];
//             Arrays.fill(ref, -1);
//             for(int j = 0; j < arr[i].length(); j++){
//                 ref[arr[i].charAt(j)-'a']++;
//             }
//             List<String> temp = new ArrayList<String>();
//             for(int j = i; j < arr.length; j++){
//                 if( arr[j] == "used"){
//                     continue;
//                 }
//                 int[] res = new int[26];
//                 Arrays.fill(res, -1);
//                 for(int k = 0; k < arr[j].length(); k++){
//                     res[arr[j].charAt(k)-'a']++;
//                 }
//                 boolean check = true;
//                 for(int k = 0; k < res.length; k++){
//                     if(res[k] != ref[k]){
//                         check = false;
//                     }
//                 }
//                 if(check){
//                     temp.add(arr[j]);
//                     arr[j] = "used";
//                 }
//             }
//             if(!temp.isEmpty()){
//             list.add(temp);
//             }
//         }
//         return list;
//     }
// }


// pro level approach

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}
