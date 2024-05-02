import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] map;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N+1];
        for(int i=1;i<=N;i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        arr = new int[3][N+1];
        for(int i=1;i<=N;i++) {
            arr[0][i] = Math.max(arr[1][i-1], arr[2][i-1]);
            arr[1][i] = Math.max(arr[0][i-1]+map[i], arr[1][i]);
            arr[2][i] = Math.max(arr[1][i-1]+map[i], arr[2][i]);
        }

        System.out.println(Math.max(arr[1][N],arr[2][N]));

    }
}