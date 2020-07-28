import java.util.*;
import java.io.*;

class Solution {
    private static File f=new File("Solution.txt");
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("travel_restrictions_input.txt");
        FileWriter fw=new FileWriter(f);
        LineNumberReader lnr = new LineNumberReader(fr);
        int t = Integer.parseInt(lnr.readLine().trim());
        for (int z = 0; z < t; z++) {
            int n = Integer.parseInt(lnr.readLine().trim());
            String incoming = lnr.readLine().trim();
            String outgoing = lnr.readLine().trim();
            char[][] arr = new char[n][n];
            int i = 0, j = 0;
            for (i = 0; i < n; i++) {
                boolean flag = true;
                boolean flag1 = true;
                arr[i][i] = 'Y';
                for (j = i + 1; j < n; j++) {
                    if (flag && outgoing.charAt(i) == 'Y' && incoming.charAt(j) == 'Y') {
                        arr[i][j] = 'Y';
                    } else {
                        flag = false;
                        arr[i][j] = 'N';
                    }
                    if (outgoing.charAt(j) == 'N') {
                        flag = false;
                    }

                    if (flag1 && outgoing.charAt(j) == 'Y' && incoming.charAt(i) == 'Y') {
                        arr[j][i] = 'Y';
                    } else {
                        flag1 = false;
                        arr[j][i] = 'N';
                    }
                    if (incoming.charAt(j) == 'N') {
                        flag1 = false;
                    }
                }
            }
            fw.write("Case #" + (z+1) + ":"+"\n");
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    fw.write(arr[i][j]);
                }
                fw.write("\n");
            }
            fw.flush();
        }
    }
}