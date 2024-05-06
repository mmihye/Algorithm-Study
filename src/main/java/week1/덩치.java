package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {
    static int[][] arr = new int[200][200];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(),"\n");  // 읽은 라인을 " "으로 자른다.

        int n = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[] answer = new int[n];

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i][0]>arr[j][0] && arr[i][1]>arr[j][1])
                    answer[j] += 1;
                else if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1])
                    answer[i] += 1;
            }
        }

        for(int a : answer){
            System.out.print(a+1);
            System.out.print(" ");
        }
    }
}
