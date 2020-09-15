package tao.c2020.qualif;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        LineNumberReader lnr = new LineNumberReader(fr);
        File outputFile=new File(args[1]);
        FileWriter fw=new FileWriter(outputFile);
        int cas = Integer.parseInt(lnr.readLine().trim());

        for (int c = 0; c < cas; c++) {
            int n = Integer.parseInt(lnr.readLine().trim());
            String in = lnr.readLine().trim();
            char[] ins = in.toCharArray();
            String out = lnr.readLine().trim();
            char[] outs = out.toCharArray();
            char[][] ans = new char[n][n];
            for (int i = 0; i < n; i++) {
                boolean notAllowR = false;

                for (int j = i; j < n; j++) {
                    if (i==j) ans[i][j] ='Y';
                    else {
                        if (notAllowR) ans[i][j] = 'N';
                        else {
                            if (ins[j]=='N' || (j-1>=0 && outs[j-1] == 'N') ) {
                                notAllowR = true;
                                ans[i][j] ='N';
                            } else {
                                ans[i][j]= 'Y';
                            }
                        }
                    }
                }
                boolean notAllowL = false;
                for (int j = i-1; j >=0; j--) {
                    if (notAllowL) ans[i][j] = 'N';
                    else  {
                        if (ins[j]=='N' || ( outs[j+1] == 'N') ) {
                            notAllowL = true;
                            ans[i][j] ='N';
                        } else {
                            ans[i][j]= 'Y';
                        }
                    }
                }
            }
            fw.write(String.format("Case #%d:\n", c+1));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n; j++) {
                    fw.write(ans[i][j]);
                }
                fw.write("\n");
            }
            fw.flush();
        }
    }
}
