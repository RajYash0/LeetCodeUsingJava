class Solution {
    public int countBinarySubstrings(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int c1=0;
        int c0=0;
        for(char c : s.toCharArray()){
            if(c=='0'){
                if(c1!=0){
                    list.add(c1);
                    c1=0;
                }
                c0++;
            }else{
                if(c0!=0){
                    list.add(c0);
                    c0=0;
                    }
                c1++;
            }
        }
        if(c0!=0){
            list.add(c0);
        }
        if(c1!=0){
            list.add(c1);
        }
        int ans=0;
        for(int i = 1;i<list.toArray().length;i++){
            ans+=Math.min(list.get(i),list.get(i-1));
        }
        return ans;
    }
}
