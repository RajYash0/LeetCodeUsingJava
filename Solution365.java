class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity == 0) return true;
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
