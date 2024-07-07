package week2_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    private static int M;
    private static int N;

    private static int[][] arr;
    private static int answer=-1;
    private static int num=0;
    private static Queue<Pair> queue = new LinkedList<>();
    private static Queue<Pair> queue2 = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1, 0, -1};

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
                if(arr[i][j]==1)
                    queue.offer(new Pair(i, j));
                else if (arr[i][j]==0) {
                    num+=1;
                }
            }
        }
        if(num==0) {
            System.out.println("0");
            return;
        }

        do {
            answer += 1;
            // 하루
            queue2.clear();
            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];

//                    System.out.println(x+", "+y);

                    if (x < 0 || y > M-1 || y < 0 || x > N-1)
                        continue;

                    if (arr[x][y] == 1 || arr[x][y] == -1)
                        continue;

                    // 주변 토마토 익기
                    if (arr[x][y] == 0) {
                        arr[x][y] = 1;
                        queue2.add(new Pair(x, y));
                        num-=1;
                    }
                }
            }
            queue= new LinkedList<>(queue2);

        }while(!queue2.isEmpty());


        // 모두 익은 상태
        if(num !=0)
            System.out.println("-1");
        else
            System.out.println(answer);



    }

    public static class Pair{
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

}
