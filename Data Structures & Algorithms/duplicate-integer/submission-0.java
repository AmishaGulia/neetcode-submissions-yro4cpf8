class Solution {
    public boolean hasDuplicate(int[] nums) {
      HashMap<Integer,Integer>m1=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        if(m1.containsKey(nums[i])){
            System.out.println("dup found:"+nums[i]);
            return true;  
        }
        else{
            m1.put(nums[i],i);
            
        }

      }
    return false;  
    }
     
}

