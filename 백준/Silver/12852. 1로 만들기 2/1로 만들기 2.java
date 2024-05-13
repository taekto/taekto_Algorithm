import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static int[] arr = new int[1000001];
    static int[] pre = new int[1000001];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pre[1] = 1;
        for(int i=2;i<=1000000;i++) {
            arr[i] = arr[i-1]+1;
            pre[i] = i-1;
            if(i%2 == 0 && arr[i] > arr[i/2]+1) {
                arr[i] = Math.min(arr[i/2]+1, arr[i]);
                pre[i] = i/2;
            };
            if(i%3 == 0 && arr[i] > arr[i/3]+1) {
                arr[i] = Math.min(arr[i/3]+1, arr[i]);
                pre[i] = i/3;
            }
        }

        System.out.println(arr[N]);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        while(N != pre[N]) {
            q.add(pre[N]);
            N = pre[N];
        }
        while(!q.isEmpty()) {
            System.out.print(q.poll()+" ");
        }
    }
}