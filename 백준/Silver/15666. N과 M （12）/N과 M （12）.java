import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] ans;
    static int pre;
    static StringBuilder sb = new StringBuilder();
    static void func(int depth, int idx) {
        if(depth == M) {
            for(int i=0;i<M;i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        pre = -1;

        for(int i=idx;i<N;i++) {
            if(pre != arr[i]) {
                ans[depth] = arr[i];
                func(depth+1, i);
                pre=arr[i];
                ans[depth] = 0;
            }
        }

        pre = -1;

    }


     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         arr = new int[N];
         ans = new int[M];
         st = new StringTokenizer(br.readLine());
         for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
         }
         Arrays.sort(arr);
         func(0, 0);
         System.out.println(sb.toString());
    }
}