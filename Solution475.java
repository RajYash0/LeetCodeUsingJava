class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int res = 0;
        for (int h : houses) {
            while (i + 1 < heaters.length && Math.abs(heaters[i+1] - h) <= Math.abs(heaters[i] - h)) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - h));
        }
        return res;
    }
}