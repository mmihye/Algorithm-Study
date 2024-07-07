package week2_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자_카드2 {

    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();


    private static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(st.nextToken());
            /*
             * getOrDefault(key, defaultValue)
             * key에 대해 map에 저장 된 value를 반환한다.
             * 만약 value가 없을 경우 defaultValue값을 반환한다.
             */
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for(int j =0;j<M;j++){
            int y = Integer.parseInt(st.nextToken());
            sb.append(hashMap.getOrDefault(y, 0)).append(' ');

        }

        System.out.println(sb);

    }
}
