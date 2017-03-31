/*
ID: jameszh1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class milk2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();
        int length = Integer.parseInt(br.readLine());
        for (int i = 0; i < length; i++) {
            String[] timeInfo = br.readLine().split(" ");
            Schedule oneSchedule = new Schedule(Integer.parseInt(timeInfo[0]), Integer.parseInt(timeInfo[1]));
            schedules.add(oneSchedule);
        }
        Collections.sort(schedules, new MyCompare());
        int start = schedules.get(0).start;
        int end = schedules.get(0).end;
        int intervalMilked = end - start;
        int intervalNotMilked = 0;

        for (int i = 1; i < schedules.size(); i++) {
            if (schedules.get(i).start > end) {
                int newIntervalNotMilked = schedules.get(i).start - end;
                intervalNotMilked = Math.max(intervalNotMilked, newIntervalNotMilked);
                start = schedules.get(i).start;
                end = schedules.get(i).end;

            } else if (schedules.get(i).start <= end) {
                int newIntervalMilked = schedules.get(i).end - start;
                intervalMilked = Math.max(newIntervalMilked, intervalMilked);
                end = Math.max(end, schedules.get(i).end);
            }
        }

        pw.println(intervalMilked + " " + intervalNotMilked);
        pw.close();
        br.close();
    }

}

class Schedule {
    public int start;
    public int end;
    public Schedule (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyCompare implements Comparator<Schedule> {
    public int compare(Schedule a, Schedule b) {
        if (a.start > b.start) return 1;
        else if (a.start < b.start) return -1;
        else return 0;
    }
}


