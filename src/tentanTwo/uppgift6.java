package tentanTwo;

import java.util.Arrays;

public class uppgift6 {
    public static void main(String[] args){
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7},4));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},4));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},9));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},12));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},15));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},20));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},21));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},24));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},27));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},5));
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7,9,9,9,9,9,9,9,11,11,11,11,12,12,12,12,12,12,12,12,12,15,15,15,20,21,21,21,21,24},8));

    }
    /*private static int nrOf(int[] numbers, int target) {
        if (numbers.length == 1 && numbers[0]==target) {
            return 1;
        }
        if (numbers.length == 1 && numbers[0]!=target){
            return 0;
        }

        int mid = numbers.length/2;

        int[]left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i]=numbers[i];
        }

        int[]right = new int[numbers.length-mid];
        for (int i = 0; mid+i < numbers.length; i++) {
            right[i]=numbers[mid+i];
        }
        int a = nrOf(left,target);
        int b = nrOf(right,target);
        int mer = a+b;

        return mer;
    }*/

    private static int nrOf(int[] numbers, int target) {
        return nrOf(numbers,target,0,numbers.length-1);
    }

    private static int nrOf(int[] numbers, int target, int left, int right) {
        if(left==right){
            if(numbers[left]==target) return 1;
            return 0;
        }
        int middle=(left+right)/2;
        if(target==numbers[middle]) return nrOf(numbers,target,left,middle)+nrOf(numbers, target,middle+1,right);
        if(target<numbers[middle]) return nrOf(numbers,target,left,middle);
        return nrOf(numbers, target,middle+1,right);
    }

/*    private static int nrOf2(int[] numbers, int target, int left, int right) {
        if(left>right) return 0;
        if(left==right){
            if(numbers[left]==target) return 1;
            return 0;
        }
        int middle=(left+right)/2;
        if(target==numbers[middle]) return 1+nrOf(numbers,target,left,middle-1)+nrOf(numbers, target,middle+1,right);
        if(target<numbers[middle]) return nrOf(numbers,target,left,middle-1);
        return nrOf(numbers, target,middle+1,right);
    }*/
/*


    public static void main(String[] args) {
        System.out.println(nrOf(new int[]{2,2,2,2,4,4,4,5,7,7,7},4));
    }
    private static int nrOf(int[] numbers, int target) {
        if (numbers.length == 1 && numbers[0]==target) {
            return 1;
        }
        if (numbers.length == 1 && numbers[0]!=target){
            return 0;
        }

        int mid = numbers.length/2;

        int[]left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i]=numbers[i];
        }
        System.out.println(Arrays.toString(left));
        int[]right = new int[numbers.length-mid];
        for (int i = 0; mid+i < numbers.length; i++) {
            right[i]=numbers[mid+i];
        }
        int a = nrOf(left,target);
        int b = nrOf(right,target);
        int mer = a+b;

        return mer;
    }*/
}
