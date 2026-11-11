class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int low=0,high=0,len=0,startIndex=0;
        int res = Integer.MAX_VALUE;
        int [] current = new int[256];
        int [] target = new int[256];

        for(int i = 0;i<n2;i++)
        {
            target[t.charAt(i)]++;
        }
        if(n1<n2)
            return "";

        for(high=0;high<n1;high++)
        {
            current[s.charAt(high)]++;
            while(check(current,target))
            {
                len = high - low +1;
                if(len<res)
                {
                    res = len;
                    startIndex = low;
                }
                current[s.charAt(low)]--;
                low++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + res);
        

    }

    private boolean check(int[] current,int[] target)
    {
        for(int i=0;i<256;i++)
        {
            if(current[i]<target[i])
            {
                return false;
            }
        }
        return true;
    }
}
