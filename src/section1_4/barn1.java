package src.section1_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

/*
ID: jameszh1
LANG: JAVA
TASK: barn1
*/
public class barn1 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        //load data
        String[] line = br.readLine().split(" ");
        int numOfBoard = Integer.parseInt(line[0]);
        int stalls = Integer.parseInt(line[1]);
        int cows = Integer.parseInt(line[2]);
        ArrayList<Integer> occupiedStall = new ArrayList<>();
        for (int i = 0; i < cows;i++) {
            occupiedStall.add(Integer.parseInt(br.readLine()));
        }

        if (numOfBoard > cows) {
            pw.println(cows);
        } else {
            //sort arraylist
            Collections.sort(occupiedStall);
            ArrayList<Integer> interval = new ArrayList<>();
            for (int i = 0; i < occupiedStall.size() - 1; i++) {
                interval.add(occupiedStall.get(i + 1) - occupiedStall.get(i) - 1);
            }
            Collections.sort(interval);

            int totalLength = occupiedStall.get(occupiedStall.size() - 1) - occupiedStall.get(0) + 1;
            for (int i = numOfBoard - 2; i >= 0; i--) {
                totalLength -= interval.get(interval.size() - i - 1);
            }
            pw.println(totalLength);
        }
        pw.close();
        br.close();
    }
}
