import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static void func(int depth, int idx) {
        if(depth == M) {
            for(int i=0;i<M;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx;i<=N;i++) {
            arr[depth] = i;
            func(depth+1, i);
            arr[depth] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        func(0,1);
        System.out.println(sb.toString());
    }
}