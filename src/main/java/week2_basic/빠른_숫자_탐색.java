package week2_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빠른_숫자_탐색 {

    private static int[][] arr = new int[5][5];
    private static Queue<Pair> queue = new LinkedList<>();
    private static int r;
    private static int c;

    private static int x,y;

    private static int[] idy = {-1, 1, 0, 0};
    private static int[] idx = {0, 0, -1, 1};

    private static int[][] distance = new int[5][5];

    private static boolean success=false;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력받기
        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<5;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j]=-1;
            }
        }
        st = new StringTokenizer(br.readLine()," ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        Pair student = new Pair(r, c);


        queue.offer(student);
        distance[student.x][student.y]=0;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            for(int i=0;i<4;i++){
                x = p.x + idx[i];
                y = p.y + idy[i];

                if(x<0 || y<0 || x>4 || y>4)
                    continue;

                if(arr[x][y]== -1)
                    continue;

                if(arr[x][y]==0 && distance[x][y]<0){
                    queue.add(new Pair(x,y));
                    distance[x][y]=distance[p.x][p.y]+1;
                }

                if(arr[x][y]==1 && distance[x][y]<0){
                    success=true;
                    queue.clear();
                    distance[x][y]=distance[p.x][p.y]+1;
                    break;
                }
            }
        }


        if(success)
            System.out.println(distance[x][y]);
        else
            System.out.println(-1);



    }

    private static class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x =x;
            this.y=y;
        }
    }
}
