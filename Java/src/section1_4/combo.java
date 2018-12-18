package src.section1_3;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*
ID: jameszh1
LANG: JAVA
TASK: combo
*/
public class combo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("combo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int range = Integer.parseInt(br.readLine());
        String[] johnLine = br.readLine().split(" ");
        String[] masterLine = br.readLine().split(" ");
        int[] johnCombination = new int[3];
        int[] masterCombination = new int[3];
        for (int i = 0; i < johnLine.length; i++) {
            johnCombination[i] = Integer.parseInt(johnLine[i]);
        }
        for (int i = 0; i < masterLine.length; i++) {
            masterCombination[i] = Integer.parseInt(masterLine[i]);
        }

        Set<String> set = new HashSet();
        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <=range; j++) {
                for (int k = 1; k <= range; k++) {
                    if (isNear(new int[]{i,j,k}, johnCombination, range) || isNear(new int[]{i,j,k}, masterCombination, range)) {
                        set.add(arrayToString(new int[]{i,j,k}));
                    }
                }
            }
        }

        pw.println(set.size());
        pw.close();
        br.close();

    }


    public static String arrayToString(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ",");
        }
        return sb.toString();
    }

    public static boolean isNear(int[] a, int[] b, int N) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i] - b[i]) <= 2 || Math.abs(a[i] - b[i]) >= N - 2) {
                count++;
            }
        }
        if (count == a.length) return true;
        else return false;
    }
}
