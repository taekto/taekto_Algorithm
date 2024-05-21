import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] cost;
    static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k+1];
        cost = new int[n];

        for(int i=0;i<n;i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cost);

        for(int i=0;i<n;i++) {
            int coin = cost[i];
            for(int j=coin;j<=k;j++) {
                if(coin%j == 0) arr[j] = arr[j]+1;
                else arr[j] = arr[j-coin]+arr[j];
            }
        }
        System.out.println(arr[k]);
    }
}