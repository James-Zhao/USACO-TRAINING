import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
ID: jameszh1
LANG: JAVA
TASK: namenum
*/
public class namenum {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        BufferedReader brDict = new BufferedReader(new FileReader("dict.txt"));

        //initialization
        int[] letterValue = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,0,7,7,8,8,8,9,9,9,0};
        long num = Long.parseLong(br.readLine());
        String line = null;
        HashMap<Long, ArrayList<String>> dict = new HashMap<>();
        while ((line = brDict.readLine()) != null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < line.length(); i++) {
                sb.append(String.valueOf(letterValue[(line.charAt(i) - 'A')]));
            }
            if (dict.containsKey(Long.parseLong(sb.toString()))) {
                dict.get(Long.parseLong(sb.toString())).add(line);
            } else {
                ArrayList al = new ArrayList();
                al.add(line);
                dict.put(Long.parseLong(sb.toString()), al);
            }
        }

        if (dict.containsKey(num)) {
            ArrayList al = dict.get(num);
            for (Object s: al) {
                pw.println(s);
            }
        }
        else {
            pw.println("NONE");
        }

        pw.close();
        br.close();

    }
}
