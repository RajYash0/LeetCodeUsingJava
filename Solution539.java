import java.util.*;
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size()>1440) return 0;
        int n=timePoints.size();
        int[] t=new int[n];
        for(int i=0;i<n;i++){
            String s=timePoints.get(i);
            int hh=Integer.parseInt(s.substring(0,2));
            int mm=Integer.parseInt(s.substring(3,5));
            t[i]=hh*60+mm;
        }
        Arrays.sort(t);
        int ans=1440;
        for(int i=1;i<n;i++) ans=Math.min(ans,t[i]-t[i-1]);
        ans=Math.min(ans, t[0]+1440-t[n-1]);
        return ans;
    }
}