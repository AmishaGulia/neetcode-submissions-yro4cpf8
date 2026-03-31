class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> m1=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp =target-nums[i];
            if(m1.containsKey(comp)){
               return new int[]{m1.get(comp), i};
                
            }
            else{
                m1.put(nums[i],i);
            }
        } 
        return new int[]{};
       
    }
     public static void main(String args[]){
            
        }
}
