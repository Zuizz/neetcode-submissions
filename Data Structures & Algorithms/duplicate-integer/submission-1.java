class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        boolean result = false;
        for(int i =0;i<nums.length;i++)
        {
            result = set.add(nums[i]);
            if(!result)
            {
                return true;
            }
        }
        return false;
    }

}