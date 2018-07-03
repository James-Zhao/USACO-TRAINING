/*
ID: jameszh1
LANG: JAVA
TASK: beads
*/

import java.io.*;
public class beads {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int numOfBeads = Integer.parseInt(br.readLine());
        String necklace = br.readLine();
//        int numOfBeads = 29;
//        String necklace = "wwwbbrwrbrbrrbrbrwrwwrbwrwrrb";
        necklace = necklace + necklace;
        int[][] left = new int[necklace.length() + 1][2];
        int[][] right = new int[necklace.length() + 1][2];
        left[0][0] = left[0][1] = 0;

        for (int i = 1; i <= necklace.length(); i++) {
            if (necklace.charAt(i - 1) == 'r') {
                left[i][0] = left[i - 1][0] + 1;
                left[i][1] = 0;
            } else if (necklace.charAt(i - 1) == 'b') {
                left[i][1] = left[i - 1][1] + 1;
                left[i][0] = 0;
            } else {
                left[i][0] = left[i - 1][0] + 1;
                left[i][1] = left[i - 1][1] + 1;
            }
        }

        right[necklace.length()][0] = right[necklace.length()][1] = 0;
        for (int i=necklace.length() - 1; i >= 0; i--){
            if (necklace.charAt(i) == 'r'){
                right[i][0] = right[i + 1][0] + 1;
                right[i][1] = 0;
            } else if (necklace.charAt(i) == 'b'){
                right[i][1] = right[i + 1][1] + 1;
                right[i][0] = 0;
            } else {
                right[i][0] = right[i + 1][0] + 1;
                right[i][1] = right[i + 1][1] + 1;
            }
        }

        int m = 0;
        for (int i = 0; i < necklace.length(); i++) {
            m = Math.max(m, Math.max(left[i][0], left[i][1]) + Math.max(right[i][0], right[i][1]));
        }
        m = Math.min(m, numOfBeads);
       // System.out.print(m);
        pw.println(m);
        pw.close();
        br.close();
    }

}


