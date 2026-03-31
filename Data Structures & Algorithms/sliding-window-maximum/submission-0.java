class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       



    // Edge case
    if (nums.length == 0) return new int[0];

    int n = nums.length;

    // Result array of size (n - k + 1)
    int[] result = new int[n - k + 1];

    // Deque to store indices
    Deque<Integer> dq = new ArrayDeque<>();

    int index = 0; // result array index

    for (int i = 0; i < n; i++) {

        // 1. Remove elements out of current window
        if (!dq.isEmpty() && dq.peekFirst() == i - k) {
            dq.pollFirst();
        }

        // 2. Remove all smaller elements from back
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
            dq.pollLast();
        }

        // 3. Add current index
        dq.offerLast(i);

        // 4. Window formed → store max
        if (i >= k - 1) {
            result[index++] = nums[dq.peekFirst()];
        }
    }

    return result;
}
    }