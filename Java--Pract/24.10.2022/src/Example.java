import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;



class Example{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();

//        int count = 0;
//        for (int i = 0; i < s.toCharArray().length; i++) {
//            if (s.toCharArray()[i] == 'f'){
//                count++;
//            }
//        }
//        System.out.println(count);

//        int count = 0;
//        String c = sc.nextLine().toLowerCase();
//        String[] arr = s.toLowerCase().split("");
//        for (String str : arr){
//            if (str.contains(c)){
//                count++;
//            }
//        }
//        System.out.println(count);

//        int num = 0;
//        int let = 0;
//        for(char str : s.toCharArray()){
//            if (Character.isLetter(str)){
//                let++;
//            }
//            if (Character.isDigit(str)){
//                num++;
//            }
//        }
//        if (num > let){
//            System.out.println("Digit");
//        }
//        else if (num < let){
//            System.out.println("Letter");
//        }
//        else {
//            System.out.println("Equal");
//        }

//        for (char a : s.toCharArray()){
//            if (Character.isDigit(a) || Character.isLetter(a) || a==' '){
//                System.out.print(a);
//            }
//        }

//        boolean rigth = false;
//        for (int i = 0; i < s.toLowerCase().toCharArray().length; ++i){
//            for (int j = s.toLowerCase().toCharArray().length - 1; j >= 0; --j) {
//                if (s.toCharArray()[i] == s.toCharArray()[j]) {
//                    rigth = true;
//                    break;
//                }
//            }
//        }
//        if (rigth){
//            System.out.print("YES");
//        }
//        else{
//            System.out.print("NO");
//        }

//        String[] arr = s.split(" ");
//        int[] nums = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            nums[i] = arr[i].length();
//        }
//        System.out.print(Arrays.stream(nums).max().getAsInt());

//        char[] chars = s.toLowerCase().replaceAll(" ", "").toCharArray();
//        Arrays.sort(chars);
//        int count = 1;
//        int max = 0;
//        char res = '\0';
//        for (int i = 0; i < chars.length; i++) {
//            for (int j = i+1; j < chars.length; j++) {
//                if (chars[i] == chars[j]){
//                    count++;
//                }
//            }
//            if (count > max){
//                max = count;
//                res = chars[i];
//                count = 1;
//            }
//            else count = 1;
//        }
//        System.out.print(res + " " + max);

//        int a = sc.nextInt();
//        for (int i = 1; i < a + 1; i++) {
//            System.out.println(i);
//        }

//        String s = sc.nextLine();
//        String[] arr = s.toLowerCase().split(" ");
//        String exist = "No";
//        for (String str : arr){
//            if (str.equals("повторение")){
//                exist = "YES";
//            }
//        }
//        System.out.println(exist);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            arr.add(0);
        }
        arr.add(1);
        for(int i : arr){
            System.out.print(i + " ");
        }

    }
}