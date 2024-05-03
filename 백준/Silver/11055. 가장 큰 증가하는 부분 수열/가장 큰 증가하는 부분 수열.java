import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        sum = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i];
        }
        for(int i=1;i<=N;i++) {
            for(int j=1;j<i;j++) {
                if(arr[j]<arr[i]) {
                    sum[i] = Math.max(sum[i], sum[j]+arr[i]);
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=N;i++) {
            ans = Math.max(sum[i], ans);
        }
        System.out.println(ans);
    }
}