import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for(int i=4;i<=100;i++) {
            arr[i] = arr[i-2]+arr[i-3];
        }
        for(int tc=1;tc<=T;tc++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N]);
        }
    }
}