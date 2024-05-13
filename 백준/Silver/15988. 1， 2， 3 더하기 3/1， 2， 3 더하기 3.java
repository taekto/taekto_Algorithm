import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new long[1000001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i=4;i<=1000000;i++) {
            arr[i] = (arr[i-3]%1000000009+arr[i-2]%1000000009+arr[i-1]%1000000009)%1000000009;
        }
        for(int tc=1;tc<=T;tc++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N]);
        }
    }
}