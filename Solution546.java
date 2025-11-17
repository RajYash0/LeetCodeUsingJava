public class Solution {
    int[][][] dp;
    int[] a;
    public int removeBoxes(int[] boxes){
        a=boxes;
        int n=boxes.length;
        dp=new int[n][n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) for(int k=0;k<n;k++) dp[i][j][k]=-1;
        return dfs(0,n-1,0);
    }
    private int dfs(int l,int r,int k){
        if(l>r) return 0;
        if(dp[l][r][k]!=-1) return dp[l][r][k];
        int rr=r;
        int kk=k;
        while(rr>l && a[rr]==a[rr-1]){
            rr--;
            kk++;
        }
        int res=dfs(l,rr-1,0)+(kk+1)*(kk+1);
        for(int i=l;i<rr;i++){
            if(a[i]==a[rr]){
                res=Math.max(res,dfs(l,i,kk+1)+dfs(i+1,rr-1,0));
            }
        }
        dp[l][r][k]=res;
        return res;
    }
}
