class Solution {
    public boolean hasAlternatingBits(int n) {
        String bi = Integer.toBinaryString(n);
        int i = 1;
        while(i<bi.length()){
            if((bi.charAt(i-1)^bi.charAt(i))!=1){
                return false;
            }
            i++;
        }
        return true;
    }
}
