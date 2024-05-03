import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+2][n+2];
        sum = new int[n+2][n+2];
        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                if(j == 1) sum[i][j] = arr[i][j] + sum[i-1][j];
                else if(j == i) sum[i][j] = arr[i][j] + sum[i-1][j-1];
                else sum[i][j] = arr[i][j] + Math.max(sum[i-1][j-1], sum[i-1][j]);
            }
        }
        int max = 0;

        for(int i=1;i<=n;i++) {
            max = Math.max(max, sum[n][i]);
        }
        System.out.println(max);
    }
}