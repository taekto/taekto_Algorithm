import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;
    static void func(int depth) {
        if(depth == M) {
            for(int i=0;i<M;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                func(depth+1);
                arr[depth] = 0;
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        arr = new int[N];
        func(0);
        System.out.println(sb.toString());
    }
}