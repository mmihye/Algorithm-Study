package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 일곱난쟁이 {
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        for (int i = 0; i < 9; i++) {
            stk = new StringTokenizer(br.readLine(),"/n");
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int sum = Arrays.stream(arr).sum();
        int diff = sum - 100;

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int k =0;

        loop:
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                k = list.get(i)+list.get(j);
                if(k==diff){
                    list.remove(i);
                    list.remove(j-1);
                    break loop;
                }
            }
        }

        Collections.sort(list);
        for(int n : list){
            System.out.println(n);
        }
    }
}
