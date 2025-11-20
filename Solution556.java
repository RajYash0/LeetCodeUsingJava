class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return -1;
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        reverse(arr, i + 1, arr.length - 1);
        long val = Long.parseLong(new String(arr));
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++; r--;
        }
    }
}
