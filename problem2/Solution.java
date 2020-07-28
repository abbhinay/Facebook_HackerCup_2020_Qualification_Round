import java.util.*;
import java.io.*;
class Solution{
    private static File f=new File("Solution.txt");
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("alchemy_input.txt");
        FileWriter fw=new FileWriter(f);
        LineNumberReader lnr = new LineNumberReader(fr);
        int t = Integer.parseInt(lnr.readLine().trim());
        for(int z=0; z<t; z++){
            int n = Integer.parseInt(lnr.readLine().trim());
            String str = lnr.readLine().trim();
            ArrayList<Character> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(str.charAt(i));
            }
            int left = 0;
            int right = 2;
            while(right<list.size()){
                int count = 0;
                count += list.get(left);
                count += list.get(left+1);
                count += list.get(right);
                if(count==196){
                    list.set(left, 'A');
                    list.subList(left+1, right+1).clear();
                    left=0;
                    right=2;
                }else if(count==197){
                    list.set(left, 'B');
                    list.subList(left+1, right+1).clear();
                    left=0;
                    right=2;
                }else{
                    left++;
                    right++;
                }
            }
            fw.write("Case #" + (z+1) + ": ");
            if(list.size()==1){
                fw.write("Y"+"\n");
            }else{
                fw.write("N"+"\n");
            }
            fw.flush();
        }
    }
}