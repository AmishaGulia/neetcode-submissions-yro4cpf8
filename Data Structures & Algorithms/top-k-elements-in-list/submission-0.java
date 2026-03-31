class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent
            }
        }

        // Step 3: Extract results
        int[] result = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) { 
    }
}
