package week1_basic;

import java.util.*;
import java.io.*;

public class 제로 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), "/n");

        int k = Integer.parseInt(stk.nextToken());

        Stack<Number> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine(), "/n");
            int n = Integer.parseInt(stk.nextToken());
            if(n!=0)
                stack.push(n);
            else
                stack.pop();
        }

        int sum = 0;
        for(Number n : stack){
            sum += n.intValue();
        }

        System.out.println(sum);


    }

}