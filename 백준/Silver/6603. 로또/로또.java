import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] S;
    static int k;
    static boolean[] visited;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    static void func(int depth, int idx) {
        if(depth == 6) {
            for(int i=0;i<6;i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx;i<k;i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = S[i];
                func(depth+1, i+1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            S = new int[k];
            visited = new boolean[k];
            for(int i=0;i<k;i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            ans = new int[6];
            func(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}