package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 베르트랑_공준 {
    static boolean[] isPrime;
    static int[] number;

    static int N = 123456;

    static void isPrime_fun() {
        int n = N*2;

        isPrime = new boolean[n + 1];
        number = new int[n+1];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        isPrime_fun();

        int sum = 0;
        for(int i =1;i<isPrime.length;i++){
            if(isPrime[i])
                sum +=1;
            number[i] = sum;
        }

        while(true){
            stk = new StringTokenizer(br.readLine(), "/n");
            int N = Integer.parseInt(stk.nextToken());

            if(N == 0)
                break;

            System.out.println(number[2*N] - number[N]);
        }

    }
}
