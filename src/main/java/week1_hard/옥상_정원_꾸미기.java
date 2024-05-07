package week1_hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 옥상_정원_꾸미기 {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        array = new int[n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            array[i] = Integer.parseInt(stk.nextToken());
        }

        long sum = 0;

        for(int j =0;j<n-1;j++){
            for(int k=j+1;k<n;k++){
                int x = array[j];
                int y = array[k];
                if(x<=y)
                    break;
                else
                    sum+=1;
            }
        }

        System.out.println(sum);
    }
}
