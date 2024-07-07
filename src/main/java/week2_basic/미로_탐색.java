package week2_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로_탐색 {

    private static int N;
    private static int M;
    private static Queue<Pair> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        char[][] miro = new char[N][M];
        int[][] dist = new int[N][M];
        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int i=0; i<N; i++){
            String line = bf.readLine();
            for(int j=0; j<M; j++){
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1;
            }
        }

        qu.offer(new Pair(0,0));
        dist[0][0] = 0;

        while(!qu.isEmpty()) {
            Pair p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (miro[nX][nY] == '0' || dist[nX][nY] != -1) {
                    continue;
                }

                qu.offer(new Pair(nX, nY));
                dist[nX][nY] = dist[p.x][p.y] + 1;
            }
        }

        System.out.print(dist[N-1][M-1] + 1);


    }

    public static class Pair{
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }


}
