package tao.c2020.round1;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionA1 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        LineNumberReader lnr = new LineNumberReader(fr);
        File outputFile=new File(args[1]);
        FileWriter fw=new FileWriter(outputFile);
        int cas = Integer.parseInt(lnr.readLine().trim());

        for (int c = 0; c < cas; c++) {
            //System.out.println("case #"+c);
            String[] str = lnr.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int w = Integer.parseInt(str[2]);
            List<Long> l = Arrays.stream(lnr.readLine().trim().split(" ")).map(Long::valueOf).collect(Collectors.toList());
            String[] str1 = lnr.readLine().trim().split(" ");
            int al = Integer.parseInt(str1[0]);
            int bl = Integer.parseInt(str1[1]);
            int cl = Integer.parseInt(str1[2]);
            int dl = Integer.parseInt(str1[3]);
            List<Long> h = Arrays.stream(lnr.readLine().trim().split(" ")).map(Long::valueOf).collect(Collectors.toList());
            String[] str2 = lnr.readLine().trim().split(" ");
            int ah = Integer.parseInt(str2[0]);
            int bh = Integer.parseInt(str2[1]);
            int ch = Integer.parseInt(str2[2]);
            int dh = Integer.parseInt(str2[3]);

            for (int i = k; i < n; i++) {
                l.add(i, (((al%dl)* (l.get(i-2)%dl))%dl + ((bl%dl)*(l.get(i-1)%dl))%dl+ cl%dl)%dl+1);
                h.add(i, (((ah%dh)* (h.get(i-2)%dh))%dh + ((bh%dh)*(h.get(i-1)%dh))%dh+ ch%dh)%dh+1);
                //h.add(i, (ah* h.get(i-2) + bh*(h.get(i-1))+ ch)%dh+1);
            }
            long resultP = 1L;
            long previousP = 0L;
            Long previousRight =0L;
            for (int i = 0; i < n; i++) {
                long curP= 0L;
                if (i==0) {
                    curP = (w+h.get(0))*2;
                }else{
                    Long startLeft = l.get(i);
                    if (startLeft>previousRight){
                        curP = (w+h.get(i))*2 + previousP;
                    }else if (startLeft == previousRight){
                        Long curH = h.get(i);
                        Long previousH = h.get(i-1);
                        curP = 2*(w) + previousP;
                        if (curH>previousH) curP += 2*(curP-previousH);
                    }else{
                        Long curLeft = l.get(i);
                        curP += (curLeft+w - previousRight)*2+ previousP;
                        Long previousHmax = Long.MIN_VALUE;
                        for (int j = i-1; j >=0 ; j--) {
                            if (l.get(j)+w >=curLeft){
                                previousHmax = Math.max(previousHmax, h.get(j));
                            }else {
                                break;
                            }
                        }
                        Long curH = h.get(i);
                        if (curH>previousHmax) curP+= (curH-previousHmax)*2;
                    }
                }
                previousRight = l.get(i)+w;
                previousP = curP;
                resultP = ((resultP% 1000000007) * (curP%1000000007))%1000000007;
               // fw.write("current p is "+curP+ " resultp is "+resultP+"\n");
                //System.out.println("current p is "+curP+ " resultp is "+resultP);
            }
            fw.write(String.format("Case #%d: %d\n", c+1, resultP));
            fw.flush();
        }
    }
}
