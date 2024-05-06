package week1_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 통계학 {
    static int[] array;
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        array = new int[n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(array);

        double sum = 0;
        List<Integer> list = new ArrayList<>();
        int mid = n/2;

        for(int x : array){
            sum += x;
            if(!map.containsKey(x)) map.put(x, 1);
            else map.put(x,map.get(x)+1);
        }

        System.out.println(Math.round(sum/n));

        System.out.println(array[mid]);

        int max = 0;

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if(max == 0) {
                max = pair.getValue();
                list.add(pair.getKey());
            }
            else if (max<pair.getValue()) {
                max = pair.getValue();
                list.clear();
                list.add(pair.getKey());
            }
            else if(max == pair.getValue()){
                list.add(pair.getKey());
            }
        }

        Collections.sort(list);
        if(list.size()>1)
            System.out.println(list.get(1));
        else
            System.out.println(list.get(0));

        System.out.println(array[n-1]-array[0]);


    }
}
