import java.util.*;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = row.size() - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }

    public static void main(String[] args) {
        int rowIndex = 4;
        List<Integer> result = getRow(rowIndex);
        System.out.println("Pascal's Triangle Row " + rowIndex + ": " + result);
    }
}
