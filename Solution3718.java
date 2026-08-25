class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }

        int i = 1;
        while(true){
            if (map.containsKey(k * i)) {
                i++;
            } else {
                return k * i;
            }
        }
    }
}
