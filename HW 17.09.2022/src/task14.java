import java.util.Scanner;
import java.util.ArrayList;

public class task14 {
    public static boolean isMagicSquare(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.equals("")){
                break;
            }
            lines.add(line);
        }

        int [][] square = new int[lines.size()][];
        int k = 0;
        for (int i = 0; i < lines.size(); ++i) {
            int[] newRow = new int[lines.size()];
            String[] numbers = lines.get(i).split(" ");
            for (int j = 0; j < lines.size(); ++j) {
                newRow[j] = (Integer.parseInt(numbers[j]));
            }
            square[k++] = newRow;
        }

        for (int i = 0; i < square.length - 1; i++) {
            int prevLine = 0, nowLine = 0;
            int prevCol= 0, nowCol = 0;
            int mainDiag = 0, revDiag = 0;
            for (int j = 0; j < square[i].length; j++) {
                prevLine += square[i][j];
                nowLine += square[i+1][j];
                prevCol += square[j][i];
                nowCol += square[j+1][i];
                mainDiag += square[j][j];
                revDiag += square[2-j][2-j];
            }
            if (prevCol != nowCol){
                return false;
            }
            if (prevLine != nowLine){
                return false;
            }
            if (mainDiag != revDiag){
                return false;
            }
            if (nowLine != nowCol || nowLine != mainDiag){
                return false;
            }
        }
        return  true;
    }

    public static boolean isMagicSquareList(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.equals("")){
                break;
            }
            lines.add(line);
        }
        ArrayList<ArrayList<Integer>> square = new ArrayList<>();
        for (int i = 0; i < lines.size(); ++i) {
            ArrayList<Integer> newRow = new ArrayList<>();
            String[] numbers = lines.get(i).split(" ");
            for (int j = 0; j < lines.size(); ++j) {
                newRow.add(Integer.parseInt(numbers[j]));
            }
            square.add(newRow);
        }

        for (int i = 0; i < square.size() - 1; i++) {
            int prevLine = 0, nowLine = 0;
            int prevCol= 0, nowCol = 0;
            int mainDiag = 0, revDiag = 0;
            for (int j = 0; j < square.get(i).size(); j++) {
                prevLine += square.get(i).get(j);
                nowLine += square.get(i+1).get(j);
                prevCol += square.get(j).get(i);
                nowCol += square.get(j+1).get(i);
                mainDiag += square.get(j).get(j);
                revDiag += square.get(2-j).get(2-j);
            }
            if (prevCol != nowCol){
                return false;
            }
            if (prevLine != nowLine){
                return false;
            }
            if (mainDiag != revDiag){
                return false;
            }
            if (nowLine != nowCol || nowLine != mainDiag){
                return false;
            }
        }
        return  true;
    }

}
