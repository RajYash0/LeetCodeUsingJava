class Solution {
    public int smallestIndex(int[] nums) {
        int i = 0;
        int n = nums.length;
        for(i = 0; i < n; i++){
            if(i == digitsSum(nums[i])){
                return i;
            }
        }
        return -1;
    }
    private int digitsSum(int num){
        int sum = 0;
        int digit = 0;
        while(num > 0){
            digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }
}
