// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         HashMap<Character,Integer>map= new HashMap<>();
//         HashMap<Character,Integer>map1= new HashMap<>();
//         if(s1.length()>s2.length()){
//             return false;

//         }
        
        
//     //    for (char c : s1.toCharArray()) {
            
//     //         map.put(c, map.getOrDefault(c, 0) + 1);
//     //     }
//          void per(String s1, int l, int r, List<String> result) {
//         if (l == r) {
//             result.add(s1); 
//             return;
//         }

//         for (int i = l; i <= r; i++) {
//             s1 = swap(s1, l, i);          
//             permute(s1, l + 1, r, result); 
//             s1= swap(s1, l, i);          
//         }
    
//     static String swap(String s1, int i, int j) {
//         char[] arr = s1.toCharArray();
//         char temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//         return String.valueOf(arr);
//     }

    


//         }
        
//     //     for (char c : s2.toCharArray()) {
//     //         map1.put(c, map1.getOrDefault(c, 0) + 1);
//     //     }
//     //   for(int i =0;i<s2.length();i++){
//     //     if(map1.keySet().containsAll(map.keySet())) {
//     //         return true;
//     //   }}
//     //   return false;
//       int k = s1.lenght();
//        boolean found = false;

//         for (int i = 0; i <= s2.length() - k; i++) {
//             String window = s2.substring(i, i + k);

//             if (set.contains(window)) {
//                 found = true;
//                 System.out.println("Found: " + window);
//                 break;
//             }
//         }

//         System.out.println(found);
//     }
// }


class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int k = s1.length();

        
        int[] count1 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        
        for (int i = 0; i <= s2.length() - k; i++) {

            String window = s2.substring(i, i + k);

            int[] count2 = new int[26];

            for (char c : window.toCharArray()) {
                count2[c - 'a']++;
            }

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}
            