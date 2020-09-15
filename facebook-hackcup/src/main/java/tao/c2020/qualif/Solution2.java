package tao.c2020.qualif;

import java.io.*;

public class Solution2 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        LineNumberReader lnr = new LineNumberReader(fr);
        File outputFile=new File(args[1]);
        FileWriter fw=new FileWriter(outputFile);
        int cas = Integer.parseInt(lnr.readLine().trim());

        for (int c = 0; c < cas; c++) {
            int n = Integer.parseInt(lnr.readLine().trim());
            final String str = lnr.readLine().trim();
            final char[] chars = str.toCharArray();
            int counta=0, countb=0;
            for (int i = 0; i < n; i++) {
                if (chars[i]=='A') counta++;
                else countb++;
            }
            String ans = Math.abs(counta-countb) >1 ? "N" : "Y";
            fw.write(String.format("Case #%d: %s\n", c+1, ans));
            fw.flush();
        }
    }
}
