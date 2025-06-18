class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curr = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            curr += diff;
            if (curr < 0) {
                curr = 0;
                start = i + 1;
            }
        }
        return total < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        Solution134 sol = new Solution134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(sol.canCompleteCircuit(gas, cost));  // Output: 3
    }
}
