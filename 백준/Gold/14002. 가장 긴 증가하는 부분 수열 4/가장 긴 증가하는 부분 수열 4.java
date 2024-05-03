import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] sum;
    static int[] pre;
    static int[] nxt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sum = new int[N+1];
        arr = new int[N+1];
        pre = new int[N+1];
        nxt = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++) {
            pre[i] = i;
        }
        Arrays.fill(sum ,1);
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=i;j++) {
                if(arr[j] < arr[i] && sum[i] < sum[j]+1) {
                    sum[i] = Math.max(sum[i], sum[j]+1);
                    pre[i] = j;
                }
            }
        }
        int ans = 0;
        int end = 0;
        for(int i=1;i<=N;i++) {
            if(ans < sum[i]) {
                ans = sum[i];
                end = i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(end);
        while(end != pre[end]) {
            end = pre[end];
            stack.add(end);
        }
        System.out.println(ans);
        while(!stack.isEmpty()) {
            System.out.print(arr[stack.pop()]+" ");
        }
    }
}