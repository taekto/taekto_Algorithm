import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] arr;
    static int ans = 0;
    static void func(int depth, int sum, int cnt) {
        if(depth == N) {
            if(sum == S && cnt != 0) ans++;
            return;
        }

        func(depth+1, sum+arr[depth], cnt+1);
        func(depth+1, sum, cnt);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        func(0,0, 0);
        System.out.println(ans);

    }
}