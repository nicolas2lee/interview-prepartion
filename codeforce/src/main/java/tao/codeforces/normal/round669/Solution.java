package tao.codeforces.normal.round669;

import java.util.Arrays;
import java.util.Scanner;

//1 0 1 0 1 0
//1 0 0 1 0
public class Solution {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int m = sc.nextInt();
        int[] a =  new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int left=0, right=1;
        int ans=a[n-1];
        while (left+d<=n-1-right){
            int sum=0;
            for (int i = left; i < d; i++) {
                if (a[i]<=m)
                    sum+=a[i];
            }
            if (sum<a[n-1-right]) {
                ans+= a[n-1-right];
                right+=1;
            }else {
                ans+=sum;
            }
            left+=d;
        }
        int sum=0;
        if (a[n-1-right]>m){
            for (int i = left; i < n-1-right; i++) {
                if (a[i]<=m) sum+=a[i];
            }
            ans+=Math.max(sum, a[n-1-right]);
        }else {
            for (int i = left; i < n-right; i++) {
                if (a[i]<=m) sum+=a[i];
            }
            ans+=sum;
        }
        System.out.println(ans);

    }


}
