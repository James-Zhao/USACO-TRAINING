/*
ID: jameszh1
LANG: JAVA
TASK: transform
*/
import java.io.*;
public class transform {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("transform.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        //initialization
        int n = Integer.parseInt(br.readLine());
        int[][] before = new int[n][n];
        int[][] after = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                before[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                after[i][j] = line.charAt(j);
            }
        }

        if (clockwise90(before, after)) pw.println("1");
        else if (clockwise180(before, after)) pw.println("2");
        else if (clockwise270(before, after)) pw.println("3");
        else if (reflection(before, after)) pw.println("4");
        else if (combination(before, after)) pw.println("5");
        else if (noChange(before, after)) pw.println("6");
        else  pw.println("7");


        pw.close();
        br.close();
    }

    public static boolean clockwise90(int[][] before, int[][] after) {
        boolean flag = true;
        int n = before.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (before[i][j] != after[j][n - 1 - i]) return false;
            }
        }
        return flag;
    }

    public static boolean clockwise180(int[][] before, int[][] after) {
        boolean flag = true;
        int n = before.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (before[i][j] != after[n - 1 - i][n - 1 - j]) return false;
            }
        }
        return flag;
    }

    public static boolean clockwise270(int[][] before, int[][] after) {
        boolean flag = true;
        int n = before.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (before[i][j] != after[n- 1- j][i]) return false;
            }
        }
        return flag;
    }

    public static boolean reflection(int[][] before, int[][] after) {
        boolean flag = true;
        int n = before.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (before[i][j] != after[i][n - 1 - j]) return false;
            }
        }
        return flag;
    }

    public static boolean combination(int[][] before, int[][] after) {
        boolean flag = true;
        int n = before.length;
        int[][] newBefore = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newBefore[i][j] = before[i][n - 1 - j];
            }
        }
        if (clockwise90(newBefore, after) || clockwise180(newBefore, after) || clockwise270(newBefore, after)) {
            return true;
        }
        else {
            flag = false;
        }
        return flag;
    }

    public static boolean noChange (int[][] before, int[][] after) {
        boolean flag = true;
        int n = before.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (before[i][j] != after[i][j]) return false;
            }
        }
        return flag;
    }
}
