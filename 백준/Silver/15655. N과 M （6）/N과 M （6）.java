import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static void func(int depth, int idx) {
        if(depth == M) {
            for(int i=0;i<M;i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = arr[i];
                func(depth+1, i);
                visited[i] = false;
                ans[depth] = 0;
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0, 0);
        System.out.println(sb.toString());
    }
}