/*
ID: jameszh1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;
public class ride {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("test.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        Scanner in = new Scanner(f);
        String comet = null;
        String group = null;
        while (in.hasNextLine()) {
            comet = in.nextLine();
            group = in.nextLine();
        }
        if (caculate(group) == caculate(comet)) {
            out.println("GO");
        }else {
            out.println("STAY");
        }
        out.close();                                  // close the output file
    }

    public static int caculate(String str) {
        int size = str.length();
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = result * (str.charAt(i) - 'A' + 1);
        }
        return result % 47;
    }
}
