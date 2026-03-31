class Solution {
    public int lastStoneWeight(int[] stones) {
        // Max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Keep smashing until 1 or 0 stones remain
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // 2nd heaviest

            if (y != x) {
                maxHeap.offer(y - x); // push back the remaining stone
            }
        }

        // If no stones remain, return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }}