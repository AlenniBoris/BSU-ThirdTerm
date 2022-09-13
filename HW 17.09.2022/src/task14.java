import java.util.Scanner;
import java.util.ArrayList;

public class task14 {

    public static ArrayList<ArrayList<Integer>> inputMatrixArrayList() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> rows = new ArrayList<>();
        while (in.hasNextLine()) {
            String row = in.nextLine();
            if (row.equals(""))
                break;

            rows.add(row);
        }

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rows.size(); ++i) {
            ArrayList<Integer> newRow = new ArrayList<>();
            String[] numbers = rows.get(i).split(" ");
            for (int j = 0; j < rows.size(); ++j) {
                newRow.add(Integer.parseInt(numbers[j]));
            }
            matrix.add(newRow);
        }
        return matrix;
    }

    public static int[][] inputMatrixArray() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> rows = new ArrayList<>();
        while (in.hasNextLine()) {
            String row = in.nextLine();
            if (row.equals(""))
                break;

            rows.add(row);
        }

        int[][] matrix = new int[rows.size()][];
        int k = 0;
        for (int i = 0; i < rows.size(); ++i) {
            int[] newRow = new int[rows.size()];
            String[] numbers = rows.get(i).split(" ");
            for (int j = 0; j < rows.size(); ++j) {
                newRow[j] = (Integer.parseInt(numbers[j]));
            }
            matrix[k++] = newRow;
        }

        return matrix;
    }

    public static boolean isMagicSquareArrayList(ArrayList<ArrayList<Integer>> matrix) {

        for (int i = 0; i < matrix.size() - 1; ++i) {
            int previousRow = 0;
            int row = 0;

            int previousColumn = 0;
            int column = 0;

            int mainDiagonal = 0;
            int sideDiagonal = 0;
            for (int j = 0; j < matrix.get(i).size(); ++j) {
                previousRow += matrix.get(i).get(j);
                row += matrix.get(i + 1).get(j);

                previousColumn += matrix.get(j).get(i);
                column += matrix.get(j).get(i + 1);

                mainDiagonal += matrix.get(j).get(j);
                sideDiagonal += matrix.get(2 - j).get(2 - j);
            }

            if (row != previousRow)
                return false;
            if (column != previousColumn)
                return false;
            if (mainDiagonal != sideDiagonal)
                return false;
            if (row != column || row != mainDiagonal)
                return false;
        }

        return true;
    }

    public static boolean isMagicSquareArray(int[][] matrix) {

        for (int i = 0; i < matrix.length - 1; ++i) {
            int previousRow = 0;
            int row = 0;

            int previousColumn = 0;
            int column = 0;

            int mainDiagonal = 0;
            int sideDiagonal = 0;
            for (int j = 0; j < matrix[i].length; ++j) {
                previousRow += matrix[i][j];
                row += matrix[i + 1][j];

                previousColumn += matrix[j][i];
                column += matrix[j][i + 1];

                mainDiagonal += matrix[j][j];
                sideDiagonal += matrix[2 - j][2 - j];
            }

            if (row != previousRow)
                return false;
            if (column != previousColumn)
                return false;
            if (mainDiagonal != sideDiagonal)
                return false;
            if (row != column || row != mainDiagonal)
                return false;
        }

        return true;
    }
}
