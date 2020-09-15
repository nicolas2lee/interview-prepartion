package tao.c2019.qualif;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        LineNumberReader lnr = new LineNumberReader(fr);
        File outputFile=new File(args[1]);
        FileWriter fw=new FileWriter(outputFile);
        int cas = Integer.parseInt(lnr.readLine().trim());

        for (int c = 0; c < cas; c++) {
            final String str = lnr.readLine().trim();
            final char[] chars = str.toCharArray();
            int nbDot = 0;
            int nbB = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '.') nbDot++;
                else if (chars[i] == 'B') nbB++;
            }
            String ans = "Y";
            if (nbB>=nbDot && nbB+1!=chars.length) ans="Y";
            else ans = "N";
            fw.write(String.format("Case #%d: %s\n", c+1, ans));
            fw.flush();
        }
    }
}
