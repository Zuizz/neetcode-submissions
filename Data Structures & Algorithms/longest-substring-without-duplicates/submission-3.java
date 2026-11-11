class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low=0,high=0,len=0;
        int res = Integer.MIN_VALUE;
        Map<Character,Integer> f = new HashMap<>();

        for(high=0;high<n;high++)
        {
            f.put(s.charAt(high), f.getOrDefault(s.charAt(high),0)+1);
            len = high - low +1;
            while(f.size()<len)
            {
                f.put(s.charAt(low),f.get(s.charAt(low))-1);
                if(f.get(s.charAt(low)) == 0)
                {
                    f.remove(s.charAt(low));
                }
                low++;
                len = high - low + 1;
            }
            res = Math.max(len,res);
        }
        if(res == Integer.MIN_VALUE)
        return 0;
        else
            return res;
    }
}
