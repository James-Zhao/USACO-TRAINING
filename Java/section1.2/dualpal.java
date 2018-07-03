

import java.io.*;
import java.math.BigInteger;

/*
ID: jameszh1
LANG: JAVA
TASK: dualpal
*/
public class dualpal {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

        String[] input = br.readLine().split(" ");
        int number = Integer.parseInt(input[0]);
        int start = Integer.parseInt(input[1]);
        int i = start + 1;
        while (number > 0) {
            BigInteger b = new BigInteger(String.valueOf(i), 10);
            int count = 0;
            for (int base = 2; base <= 10; base++) {
                String s = b.toString(base);
                if (isPalindromic(s) && number > 0) {
                    count++;
                    if (count >= 2) {
                        pw.println(b);
                        number--;
                        break;
                    }
                }
            }
            i++;
        }

        pw.close();
        br.close();
    }

    public static boolean isPalindromic(String s) {
        StringBuffer sb = new StringBuffer(s);
        if (sb.toString().equals(sb.reverse().toString())) return true;
        else return false;
    }
}

