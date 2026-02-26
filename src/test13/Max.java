package test13;

import test.Prim;

public class Max {

    static public int solve(int[]a,int right,int left){
        if(left==right){
            return Math.max(0,a[0]);
        }
        int cen = (left+right)/2;
        int sum=0,maxLeft=0;
        for (int i = cen; i >= left; i--) {
            sum = sum+ a[i];
            maxLeft = Math.max(sum,maxLeft);
        }

        sum=0;
        int maxRight=0;
        for (int i = cen+1; i <= right; i++) {
            sum = sum+ a[i];
            maxRight = Math.max(sum,maxRight);
        }
        int all = maxRight+maxLeft;
        int af=  Math.max(all,solve(a,cen,left));
        return Math.max(af,solve(a,right,cen+1));
    }


    static public int solve(int[]a){
        int lokalasum =0;
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            lokalasum = Math.max(lokalasum+a[i],0);
            sum=Math.max(lokalasum,sum);
        }
      return sum;
    }

    public static void main(String[] args) {
       int[]list = {12,-200,11,-10,103};

       int re = Max.solve(list,list.length-1,0);
       int a = Max.solve(list);
        System.out.println(a);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }
        System.out.println("\n");
        System.out.println(re);
    }
}
