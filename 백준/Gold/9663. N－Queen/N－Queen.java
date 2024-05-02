import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[] visited1;
    static boolean[] visited2;
    static boolean[] visited3;
    static int ans = 0;
    static void func(int depth) {
        if(depth == N) {
            ans++;
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited1[i] && !visited2[depth-i+N-1] && !visited3[depth+i]) {
                visited1[i] = true;
                visited2[depth-i+N-1] = true;
                visited3[depth+i] = true;
                func(depth+1);
                visited1[i] = false;
                visited2[depth-i+N-1] = false;
                visited3[depth+i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited1 = new boolean[N];
        visited2 = new boolean[2*N-1];
        visited3 = new boolean[2*N-1];
        func(0);
        System.out.println(ans);
    }
}