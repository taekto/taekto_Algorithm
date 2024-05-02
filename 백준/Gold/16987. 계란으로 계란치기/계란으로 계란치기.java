import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] W;
    static int[] S;
    static int ans = 0;
    static int cnt = 0;
    static void func(int a) {
        if(a == N) {
            ans = Math.max(ans, cnt);
            return;
        }
        if(S[a] <= 0 || cnt == N-1) {
            func(a+1);
            return;
        }
        for(int i=0;i<N;i++) {
            if(a == i || S[i] <= 0) continue;
            S[a] -= W[i];
            S[i] -= W[a];
            if(S[a] <= 0) cnt++;
            if(S[i] <= 0) cnt++;
            func(a+1);
            if(S[a] <= 0) cnt--;
            if(S[i] <= 0) cnt--;
            S[a] += W[i];
            S[i] += W[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        W = new int[N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
            func(0);
        }
        System.out.println(ans);
    }
}