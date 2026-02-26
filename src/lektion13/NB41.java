package lektion13;

import java.util.Random;
import java.util.Scanner;

public class NB41 {

    public static int maxSum(int[] a, int left, int right) {
        if (left == right) {
            return Math.max(0, a[left]);
        }
        int center = (left + right) / 2;
        int sum = 0;
        int maxLeft = 0;
        for (int i = center; i >= left; i--) {
            sum = sum + a[i];
            maxLeft = Math.max(maxLeft, sum);
        }
        sum = 0;
        int maxRight = 0;
        for (int i = center + 1; i <= right; i++) {
            sum = sum + a[i];
            maxRight = Math.max(maxRight, sum);
        }
        int maxOverMiddle = maxLeft + maxRight;
        int leftMax = maxSum(a, left, center);
        int rightMax = maxSum(a, center + 1, right);
        return Math.max(maxOverMiddle, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Ange n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(2001) - 1000;
        }
        System.out.println("Tal:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        int maxSum = maxSum(arr, 0, n - 1);
        System.out.println("Maximal delsekvenssumma = " + maxSum);

    }
}
