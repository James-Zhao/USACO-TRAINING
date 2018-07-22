package src.section1_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
ID: jameszh1
LANG: JAVA
TASK: milk
*/
public class milk {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("milk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

        //load data
        String[] line = br.readLine().split(" ");
        int totalAmount = Integer.parseInt(line[0]);
        int numOfFarmers = Integer.parseInt(line[1]);
        ArrayList<Farmer> al = new ArrayList<>();

        if (totalAmount == 0) {
            pw.println(0);
        }

        for(int i = 0; i < numOfFarmers; i++) {
            line = br.readLine().split(" ");
            Farmer f = new Farmer(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            al.add(f);
        }
        //sort
        Collections.sort(al, new MyCompare());

        int milkAmount = 0;
        int totalPrice = 0;
        for(Farmer f: al) {
            if (milkAmount + f.amount > totalAmount) {
                pw.println(totalPrice + (totalAmount - milkAmount) * f.price);
                break;
            } else if (milkAmount + f.amount == totalAmount){
                pw.println(totalPrice + f.price * f.amount);
                break;
            }
            else {
                milkAmount += f.amount;
                totalPrice += f.price * f.amount;
            }
        }
        pw.close();
        br.close();

    }
}

class Farmer {
    public int price;
    public int amount;
    public Farmer (int price, int amount) {
        this.price = price;
        this.amount = amount;
    }
}

class MyCompare implements Comparator<Farmer> {
    public int compare(Farmer a, Farmer b) {
        if (a.price > b.price) return 1;
        else if (a.price < b.price) return -1;
        else return 0;
    }
}