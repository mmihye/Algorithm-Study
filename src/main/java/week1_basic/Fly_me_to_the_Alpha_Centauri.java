package week1_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fly_me_to_the_Alpha_Centauri {

    static long[] array = new long[100010];
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stk.nextToken());

            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());

                long k = 1;
                int result = 3;

                int dis = b-a;

                if(dis == 1)
                    System.out.println(1);
                else if(dis == 2)
                    System.out.println(2);
                else{
                    while(true){
                        if(dis <= (k+1)*(k+1)) {
                            System.out.println(result);
                            break;
                        }
                        else if(dis <= (k+1)*(k+2)) {
                            System.out.println(result + 1);
                            break;
                        }
                        k++;
                        result+=2;
                    }
                }

            }
    }
}
