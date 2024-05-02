import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[3][N+1];
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        ans = new int[3][N+1];
        ans[0][1] = map[0][1];
        ans[1][1] = map[1][1];
        ans[2][1] = map[2][1];
        
        for(int i=2;i<=N;i++) {
            ans[0][i] = Math.min(ans[1][i-1], ans[2][i-1])+map[0][i];
            ans[1][i] = Math.min(ans[0][i-1], ans[2][i-1])+map[1][i];
            ans[2][i] = Math.min(ans[0][i-1], ans[1][i-1])+map[2][i];
        }
        
        System.out.println(Math.min(ans[0][N], Math.min(ans[1][N], ans[2][N])));
    }
}