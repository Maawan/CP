package CodeForces.PractiseProblems;
/*
    link https://codeforces.com/problemset/problem/295/B
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GregandGraph {
    public static void main(String[] arsg){
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> ans = new ArrayList<>();
        int n = sc.nextInt();
        long[][] arr = new long[n][n];
        for(int i = 1; i <= n ; ++i){
            for(int j = 1 ; j <= n ; ++j){
                arr[i][j] = sc.nextLong();
            }
        }
        int[] rem = new int[n];
        for(int i = 0 ; i < n ; ++i){
            rem[i] = sc.nextInt();
        }
        reverse(rem);
        for(int k = 0 ; k < n ; ++k){
            int kth = rem[k];

            for(int i = 1 ; i <= n ; ++i){
                for(int j = 1 ; j <= n ; ++j){
                    arr[i][j] = Math.min(arr[i][kth] + arr[kth][j] , arr[i][j]);

                }
            }
            long sum = 0;
            for(int i = 1 ; i <= n ; ++i){
                for(int j = 1 ; j <= n ; ++j){
                    sum += arr[rem[i-1]][rem[j-1]];
                }
            }
            ans.add(sum);

        }

        for(int i = ans.size() - 1 ; i >= 0 ; i--){
            System.out.print(ans.get(i) + " ");
        }

    }
    private static void reverse(int[] arr){
        int j = arr.length - 1;
        for(int i = 0 ; i < arr.length / 2 ; i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }

}
