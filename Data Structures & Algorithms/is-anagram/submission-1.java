

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> m1 = new HashMap<>();

        
        for (char c : s.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        
        for (char c : t.toCharArray()) {
            if (!m1.containsKey(c)) {
                return false;
            }
            m1.put(c, m1.get(c) - 1);
            if (m1.get(c) == 0) {
                m1.remove(c); 
            }
        }

        return m1.isEmpty();
    }

    public static void main(String[] args) {
        
    }
}
