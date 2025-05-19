import java.util.Scanner;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) firstCol = true;

        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0) firstRow = true;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (firstRow)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;

        if (firstCol)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        new SetMatrixZeroes().setZeroes(matrix);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
