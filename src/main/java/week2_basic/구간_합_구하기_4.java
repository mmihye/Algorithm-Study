package week2_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 구간_합_구하기_4 {

    private static int N;
    private static int M;
    private static int[] arr;
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        hashMap.put(0, 0);
        int sum= 0;

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            hashMap.put(i + 1, sum);
        }

        for(int k=0;k<M;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if(i==j)
                System.out.println(arr[i-1]);
            else
                System.out.println(hashMap.get(j)-hashMap.get(i-1));

        }

    }
}
