/*BACK TRACKING APPROACH
Subset sum problem is to find subset of elements that are selected from a given set whose sum adds up to a given number K. 
We are considering the set contains non-negative values. It is assumed that the input set is unique (no duplicates are presented).
*/
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//reading size of subset
        int a[] = new int[n];//array creation for subset values with size n
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();//reading n values
        }
        int k = sc.nextInt();//reading constraint value k
        int c[] = new int[n];//output array with n tuple(Fixed tuple length)
        for (int i = 0; i < n; i++) {
            c[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            c[0] = a[i];
            subsetSum(a, c, 1, k, i + 1);
            if (c[0] == k) {
                System.out.println(c[0]);
            }
        }
    }
    public static void subsetSum(int a[], int c[], int in , int k, int x) {
        for (int i = x; i < a.length; i++) {
            if (place(c, a[i])) {//calling place function
                c[ in ] = a[i];
                int sum = 0;
                for (int j = 0; j < c.length; j++) {//finding sum for the array 
                    sum = sum + c[j];
                }
                if (sum == k) {//base case checking wheather k==sum or not if true print the array else call subsetSum() function
                    for (int j = 0; j < c.length; j++) {
                        if (c[j] != 0)
                            System.out.print(c[j] + " ");
                    }
                    System.out.println();
                }
                if ( in == a.length - 1) {
                //in should be less than a.length-1 otherwise it shows arrayIndexOutOfBound error 
                } else {
                    subsetSum(a, c, in +1, k, i + 1);//calling subsetSum() function with parameters 
                                                    //subsetSum(original array,output array,constraint value,index of output array) 
                    c[ in +1] = 0;
                }
            }
        }
        c[ in ] = 0;
    }
  
    //returns true when value v is not present in output array(c array) else false 
    public static boolean place(int c[], int v) {
        //System.out.println(v);
        for (int i = 0; i < c.length; i++) {
            if (c[i] == v) {
                return false;
            }
        }
        return true;
    }
}
