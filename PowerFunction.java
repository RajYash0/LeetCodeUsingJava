public class PowerFunction {
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        while (N > 0) {
            if ((N & 1) == 1) result *= x;
            x *= x;
            N >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));   // 1024.0
        System.out.println(myPow(2.1, 3));    // 9.261
        System.out.println(myPow(2.0, -2));   // 0.25
    }
}
