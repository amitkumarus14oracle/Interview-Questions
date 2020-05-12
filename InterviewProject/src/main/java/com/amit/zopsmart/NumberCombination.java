package com.amit.zopsmart;
public class NumberCombination {
    static int[] b = {1,2,3,4};
    static int count = 0;
    public static void main(String[] args) {
        combination(new int[4], 0, 4 );
        System.out.println("total count is : "+count);
    }

    public static void combination(int[] a, int k, int n) {
        if(k == n-1) {
            a[k] = 0; printVal(a,n);
            a[k] = 1; printVal(a,n);
            return;
        }
        a[k] = 0;
        combination(a, k+1, n);
        a[k] = 1;
        combination(a, k+1, n);
    }

    public static void printVal(int[] a, int n) {
        boolean printed = false;
        for(int i=0; i<n; i++) {
            if(a[i] == 1) {
                printed = true;
                System.out.print(b[i]+" ");
            }
        }
        if(!printed) {
            System.out.print("null");
        }
        System.out.println();
        count++;

    }
}
