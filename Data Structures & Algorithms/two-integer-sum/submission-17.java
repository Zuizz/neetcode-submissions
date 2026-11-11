class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> ans = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int remainder = target - nums[i];
            if(ans.containsKey(remainder))
            {
                
                return new int[]{ans.get(remainder),i};
            }
            else
            ans.put(nums[i],i);
        }
        return new int[]{};
    }
}
