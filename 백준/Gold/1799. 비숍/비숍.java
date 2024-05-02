import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] visited1;
    static boolean[] visited2;
    static int bmx = 0;
    static int wmx = 0;
    static void black(int a, int cnt) {
        if(a >= N*N) {
            bmx = Math.max(cnt, bmx);
            return;
        }

        int y = a/N;
        int x = a%N;
        int da;
        if(N%2 == 0) {
            if(x == N-1) {
                da = 1;
            }
            else if(x == N-2) {
                da = 3;
            }
            else {
                da = 2;
            }
        }
        else {
            da = 2;
        }
        if(!visited1[x-y+N-1] && !visited2[y+x] && map[y][x] == 1) {
            visited1[x-y+N-1] = true;
            visited2[y+x] = true;
            black(a+da, cnt+1);
            visited1[x-y+N-1] = false;
            visited2[y+x] = false;
        }
        black(a+da, cnt);
    }

    static void white(int a, int cnt) {
        if(a >= N*N) {
            wmx = Math.max(cnt, wmx);
            return;
        }

        int y = a/N;
        int x = a%N;
        int da;
        if(N%2 == 0) {
            if(x == N-1) {
                da = 1;
            }
            else if(x == N-2) {
                da = 3;
            }
            else {
                da = 2;
            }
        }
        else {
            da = 2;
        }
        if(!visited1[x-y+N-1] && !visited2[y+x] && map[y][x] == 1) {
            visited1[x-y+N-1] = true;
            visited2[y+x] = true;
            white(a+da, cnt+1);
            visited1[x-y+N-1] = false;
            visited2[y+x] = false;
        }
        white(a+da, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited1 = new boolean[2*N-1];
        visited2 = new boolean[2*N-1];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        black(0,0);
        white(1, 0);
        System.out.println(bmx+wmx);
    }
}