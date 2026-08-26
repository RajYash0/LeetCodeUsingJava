class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int onesCount = 0, left = 0;
        String res = "";

        for(int right = 0; right < n; right++){
            if(s.charAt(right) == '1') onesCount++;

            while(onesCount > k){
                if(s.charAt(left) == '1') onesCount--;
                left++;
            }

            if(onesCount == k){
                while(s.charAt(left) == '0') left++;
                String candidate = s.substring(left, right+1);
                if(res.isEmpty() || candidate.length() < res.length() || (candidate.length() == res.length() && candidate.compareTo(res) < 0)){
                    res = candidate;
                }
            }
        }
        return res;
    }
}
