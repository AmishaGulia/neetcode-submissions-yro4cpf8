class Solution {
    public int climbStairs(int n) {
         if (n <= 2) return n; // base cases

        int first = 1;  // ways(1)
        int second = 2; // ways(2)

        for (int i = 3; i <= n; i++) {
            int third = first + second; // ways(i) = ways(i-1) + ways(i-2)
            first = second;
            second = third;
        }

        return second; 
    }
    
public static void main (String args[]){

}
}