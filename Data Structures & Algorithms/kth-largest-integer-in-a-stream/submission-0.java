class KthLargest {
private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
       this.k = k;
        this.minHeap = new PriorityQueue<>(); // min-heap
        for (int num : nums) {
            add(num);
        }

    }
    
    public int add(int val) {
       
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll(); // remove smallest if heap grows beyond size k
        }
        return minHeap.peek(); 
        
    }
}
