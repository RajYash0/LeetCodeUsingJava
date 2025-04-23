import java.util.Scanner;
class Main {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            result += multiple;
        }
        return negative ? -result : result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        Main solution = new Main();
        System.out.println(solution.divide(dividend, divisor));
    }
}
