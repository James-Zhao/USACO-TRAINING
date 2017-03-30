/*
ID: jameszh1
LANG: JAVA
TASK: friday
*/

import java.io.*;
public class friday {

    public static void main(String[] args) throws Exception {
        int count[] = new int[7];
        BufferedReader br = new BufferedReader(new FileReader("friday.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int years = Integer.parseInt(br.readLine());
        int allDays = 0;
        for (int i = 1900; i < 1900 + years; i++) {
            for (int j = 1; j <= 12; j++) {
                count[(allDays + 13) % 7]++;
                allDays += countDaysInMonth(j, i);
            }
        }
        pw.println(count[6] + " " + count[0] + " " + count[1] + " " + count[2] + " " + count[3] + " " + count[4] + " " + count[5]);
        pw.close();
        br.close();
    }
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }else {
            return false;
        }
    }
    public static int countDaysInMonth(int month, int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                }else {
                    return 28;
                }
            default:
                return 31;
        }
    }
}

