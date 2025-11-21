class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && arr[j] != ' ') j++;
            reverse(arr, i, j - 1);
            i = j + 1;
        }
        return new String(arr);
    }
    void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}