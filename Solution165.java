public class Solution165 {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);

        for (int i = 0; i < n; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 != num2) return num1 > num2 ? 1 : -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));     // Output: 0
        System.out.println(compareVersion("1.0", "1.0.0"));      // Output: 0
        System.out.println(compareVersion("0.1", "1.1"));        // Output: -1
        System.out.println(compareVersion("1.0.1", "1"));        // Output: 1
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));  // Output: -1
    }
}
