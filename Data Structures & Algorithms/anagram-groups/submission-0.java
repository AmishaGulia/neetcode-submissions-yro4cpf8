class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
      if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            // build a key like "1#0#0#..." for counts
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append(count[i]).append("#");
            }
            String key = keyBuilder.toString();

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }  
    public static void main (String args[]){
        
    }
    }

