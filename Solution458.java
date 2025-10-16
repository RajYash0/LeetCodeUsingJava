class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        while (Math.pow(rounds, pigs) < buckets) pigs++;
        return pigs;
    }
}
