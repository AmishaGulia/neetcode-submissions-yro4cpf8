class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f = new int[26];
        
        
        for (char t : tasks) {
            f[t - 'A']++;
        }
        
        Arrays.sort(f);
        
        int maxF = f[25];
        int maxCount = 0;
        
        
        for (int i = 25; i >= 0; i--) {
            if (f[i] == maxF) {
                maxCount++;
            }
        }
        
        return Math.max(tasks.length, (maxF - 1) * (n + 1) + maxCount);
    }
}