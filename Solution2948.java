import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        int[][] elements = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            elements[i][0] = nums[i];
            elements[i][1] = i;
        }
        
        Arrays.sort(elements, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] answer = new int[n];
        
        int start = 0;
        
        while (start < n) {
            int end = start;
            
            while (end + 1 < n &&
                   (long) elements[end + 1][0] - elements[end][0] <= limit) {
                end++;
            }
            
            int[] indices = new int[end - start + 1];
            
            for (int i = start; i <= end; i++) {
                indices[i - start] = elements[i][1];
            }
            
            Arrays.sort(indices);
            
            for (int i = 0; i < indices.length; i++) {
                answer[indices[i]] = elements[start + i][0];
            }
            
            start = end + 1;
        }
        
        return answer;
    }
}
