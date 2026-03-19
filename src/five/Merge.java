package five;

public class Merge {




    public static void merge(int []a){
        if(a.length<=1){
            return;
        }
        int mid = (a.length/2);
        int[] left = new int[mid];
        int[] right = new int[a.length-mid];

        for (int i = 0; i < left.length; i++) {
            left[i]= a[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i]= a[mid+i];
        }
       merge(left);
        merge(right);

        to(left,right,a);
    }

    public static void  to(int[] left,int[]right,int[]a){
        int indexa=0,indexl=0,indexr=0;

        while (indexl< left.length && indexr < right.length){
            if(left[indexl]<right[indexr]){
                a[indexa++]=left[indexl++];
            }
            else {
                a[indexa++]=right[indexr++];
            }
        }

        while (indexl< left.length){
            a[indexa++]=left[indexl++];
        }

        while (indexr < right.length){
            a[indexa++]=right[indexr++];
        }
    }



    public static void main(String[] args) {
        int[] list =   {3,4,1,2,222222};
        Merge.merge(list);
        for (int a: list){
            System.out.print(a+" ");
        }
    }

}
