

import java.io.*;
import java.math.BigInteger;

/*
ID: jameszh1
LANG: JAVA
TASK: palsquare
*/
public class palsquare {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        int base = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 300; i++) {
            BigInteger b = new BigInteger(String.valueOf(i), 10);
            BigInteger bSquare = new BigInteger(String.valueOf(i*i), 10);
            if (isPalindromic(bSquare.toString(base))) {
                pw.println(b.toString(base).toUpperCase() + " " + bSquare.toString(base).toUpperCase());
            }
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

