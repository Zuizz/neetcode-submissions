class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low=0,high=0,len=0,maxcount=0,diff=0;
        int res = Integer.MIN_VALUE;
        int[] f = new int[255];

        for(high=0;high<n;high++)
        {
            f[s.charAt(high)]++;
            maxcount = find(f);
            len = high - low + 1;
            diff = Math.abs(len - maxcount);
            while(diff>k)
            {
                f[s.charAt(low)]--;
                low++;
                len = high - low + 1;
                maxcount = find(f);
                diff = Math.abs(len - maxcount);
            }
            len = high - low +1;
            res = Math.max(len,res);
        }
        return res;
    }
    private int find(int[] a)
    {
        int n = a.length;
        int maxc = 0;
        for(int i=0;i<n;i++)
        {
            maxc = Math.max(maxc,a[i]);
        }
        return maxc;
    }
}
