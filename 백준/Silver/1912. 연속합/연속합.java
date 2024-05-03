import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] sum;
    static int n;
    static int ans = -30000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        sum = new int[n+1];
        Arrays.fill(arr, -2000);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++) {
            sum[i] = Math.max(arr[i], sum[i-1]+arr[i]);
            if(sum[i] > ans) ans = sum[i];
        }
        System.out.println(ans);
    }
}