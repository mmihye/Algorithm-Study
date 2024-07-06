package week1_hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    int height;
    int index;

    Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
public class 탑 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        Stack<Top> stack = new Stack<>();

        int n = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n ; i++) {
            int x = Integer.parseInt(stk.nextToken());
            while(true){
                if(stack.isEmpty()){
                    System.out.print("0 ");
                    break;
                }
                int y = stack.peek().height;
                if(y>=x) {
                    System.out.print(stack.peek().index + " ");
                    break;
                }
                else
                    stack.pop();
            }
            stack.push(new Top(i+1,x));
        }

    }
}
