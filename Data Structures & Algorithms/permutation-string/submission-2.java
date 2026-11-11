class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int low =0,high=n1-1;
        Map<Character,Integer> f1 = new HashMap<>();
        Map<Character,Integer> f2 = new HashMap<>();
        if(n2<n1)
            return false;
        for(int i=0;i<n1;i++)
        {
            f1.put(s1.charAt(i),f1.getOrDefault(s1.charAt(i),0)+1);
            f2.put(s2.charAt(i),f2.getOrDefault(s2.charAt(i),0)+1);
        }
        if(f1.equals(f2))
            return true;
        
        while(high<n2)
        {
            high++;
            f2.put(s2.charAt(low),f2.get(s2.charAt(low))-1);
            if(f2.get(s2.charAt(low)) == 0)
                f2.remove(s2.charAt(low));
            low++;
            if(high==n2)
                break;
            else
                f2.put(s2.charAt(high),f2.getOrDefault(s2.charAt(high),0)+1);
            if(f1.equals(f2))
                return true;
        }
        return false;
    }
}
