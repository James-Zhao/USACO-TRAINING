/*
ID: jameszh1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;
public class gift1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int size = Integer.parseInt(br.readLine());
        String[] names = new String[size];
        HashMap<String, Integer> net = new HashMap<String, Integer>();
        for (int i = 0; i < size; i++) {
            String name = br.readLine();
            net.put(name, 0);
            names[i] = name;
        }
        for (int i = 0; i < size; i++) {
            String name = br.readLine();
            String gift = br.readLine();
            String[] temp = gift.split(" ");
            int sum = Integer.parseInt(temp[0]);
            int div = Integer.parseInt(temp[1]);
            if (div != 0) {
                for (int j = 0; j < div; j++) {
                    String target = br.readLine();
                    net.put(target, net.get(target) + sum / div);
                }
                net.put(name, net.get(name) - (sum - sum % div));
            }
        }
        for (String nameToPrint : names) {
            pw.println(nameToPrint + " " + net.get(nameToPrint));
        }
        pw.close();
        br.close();
    }

}
