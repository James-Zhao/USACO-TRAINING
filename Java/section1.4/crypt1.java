package src.section1_3;

import java.io.*;
import java.util.HashMap;

/*
ID: jameszh1
LANG: JAVA
TASK: crypt1
*/
public class crypt1 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        HashMap<Integer, Integer> hm = new HashMap();
        int numOfDigit = Integer.parseInt(br.readLine());
        int total = 0;
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            hm.put(Integer.parseInt(line[i]), 1);
        }

        for (int i = 100; i < 1000; i++) {
            if (isIn(i, hm)) {
                for (int j = 10; j < 100; j++) {
                    if (isIn(j, hm)) {
                        String str_j = String.valueOf(j);
                        int tenDigit = Integer.parseInt(str_j.substring(0,1));
                        int digit = Integer.parseInt(str_j.substring(1,2));
                        int middleResult1 = digit * i;
                        int middleResult2 = tenDigit * i;
                        if (isIn(middleResult1, hm) && isIn(middleResult2, hm) && isIn(i * j, hm) && i * j >= 1000 && i * j < 10000 && middleResult1 > 100 && middleResult1 < 1000 && middleResult2 > 100 && middleResult2 < 1000) {
                            total++;
                        }
                    }
                }
            }
        }

        pw.println(total);

        pw.close();
        br.close();
    }

    public static boolean isIn (int number, HashMap hm) {
        String str = String.valueOf(number);
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            int digit = Integer.parseInt(str.substring(i, i+1));
            if (!hm.containsKey(digit)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
