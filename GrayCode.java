import java.util.*;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode solution = new GrayCode();
        int n = 2;
        List<Integer> output = solution.grayCode(n);
        System.out.println(output);
    }
}
