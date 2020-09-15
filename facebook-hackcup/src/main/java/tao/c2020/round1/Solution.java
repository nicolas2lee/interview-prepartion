package tao.c2020.round1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static class Interval {
        Long left;
        Long right;

        public Interval(Long left, Long right) {
            this.left = left;
            this.right = right;
        }
    }
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
            List<Long> l = Arrays.stream(lnr.readLine().trim().split(" ")).map(Long::valueOf).collect(Collectors.toList());
            String[] str1 = lnr.readLine().trim().split(" ");
            int al = Integer.parseInt(str1[0]);
            int bl = Integer.parseInt(str1[1]);
            int cl = Integer.parseInt(str1[2]);
            int dl = Integer.parseInt(str1[3]);
            List<Long> w = Arrays.stream(lnr.readLine().trim().split(" ")).map(Long::valueOf).collect(Collectors.toList());
            String[] str2 = lnr.readLine().trim().split(" ");
            int aw = Integer.parseInt(str2[0]);
            int bw = Integer.parseInt(str2[1]);
            int cw = Integer.parseInt(str2[2]);
            int dw = Integer.parseInt(str2[3]);
            List<Long> h = Arrays.stream(lnr.readLine().trim().split(" ")).map(Long::valueOf).collect(Collectors.toList());
            String[] str3 = lnr.readLine().trim().split(" ");
            int ah = Integer.parseInt(str3[0]);
            int bh = Integer.parseInt(str3[1]);
            int ch = Integer.parseInt(str3[2]);
            int dh = Integer.parseInt(str3[3]);

            for (int i = k; i < n; i++) {
                l.add(i, (((al%dl)* (l.get(i-2)%dl))%dl + ((bl%dl)*(l.get(i-1)%dl))%dl+ cl%dl)%dl+1);
                w.add(i, (((aw%dw)* (w.get(i-2)%dw))%dw + ((bw%dw)*(w.get(i-1)%dw))%dw+ cw%dw)%dw+1);
                h.add(i, (((ah%dh)* (h.get(i-2)%dh))%dh + ((bh%dh)*(h.get(i-1)%dh))%dh+ ch%dh)%dh+1);
            }
            long resultP = 1L;
            long previousP = 0L;
            int previousRight =0;

            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long curP= 0L;
                if (i==0) {
                    curP = (w.get(0)+h.get(0))*2;
                    intervals.add(new Interval(l.get(0),l.get(0)+w.get(0)));
                }else{
                    Long curL = l.get(i);
                    Long curW = w.get(i);
                    Long curH = w.get(i);
                    Long gap = 0L;
                    boolean sameEdge = false;
                    for (int j = 0; j < intervals.size(); j++) {
                        final Interval cur = intervals.get(j);
                        Long left = -1L;
                        Long right = -1L;
                        if (curL >= cur.left && curL+curW <= cur.right){
                            //inside
                            curP = previousP;
                            break;
                        } 

                        if (curL+curW < cur.left || curL> cur.right) {
                            continue;
                        } else if (curL < cur.left && curL+curW >cur.left){
                            gap +=  curL+curW - cur.left;
                        } else if (curL> cur.left && curL<=cur.right && curL+curW> cur.right){
                            gap = cur.right- curL;
                        }
                    }
                }
                Collections.sort(intervals, Comparator.comparingLong(o -> o.left));
                previousP = curP;
                resultP = ((resultP% 1000000007) * (curP%1000000007))%1000000007;
                fw.write("current p is "+curP+ " resultp is "+resultP+"\n");
                //System.out.println("current p is "+curP+ " resultp is "+resultP);
            }
            fw.write(String.format("Case #%d: %d\n", c+1, resultP));
            fw.flush();
        }
    }
}
