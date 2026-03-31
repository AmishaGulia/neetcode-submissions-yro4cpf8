class Solution {
    public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
        int[] output = new int[n];

        // Step 1: compute prefix products
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: multiply by suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix;
            suffix *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
    }
}  
