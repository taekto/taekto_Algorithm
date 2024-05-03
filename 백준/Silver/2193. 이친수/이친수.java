import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[2][N+2];
        arr[1][1] = 1;
        arr[0][2] = 1;
        for(int i=3;i<=N;i++) {
            arr[0][i] = arr[0][i-1]+arr[1][i-1];
            arr[1][i] = arr[0][i-1];
        }
        System.out.println(arr[0][N]+arr[1][N]);
    }
}