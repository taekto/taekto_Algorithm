import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static char[] arr;
    static char[] ans;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static char[] filter = {'a', 'e', 'i', 'o', 'u'};

    static boolean isaeiou(char a) {
        for (char b : filter) {
            if(a == b) return true;
        }
        return false;
    }
    static void func(int depth, int idx, int ja , int mo) {
        if(depth == L) {
            if(ja >=2 && mo >= 1) {
                for(int i=0;i<L;i++) {
                    sb.append(ans[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=idx;i<C;i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = arr[i];
                if(isaeiou(arr[i])) {
                    func(depth+1, i+1, ja, mo+1);
                }
                else {
                    func(depth+1, i+1, ja+1, mo);
                }
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        ans = new char[L];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        func(0,0, 0, 0);
        System.out.println(sb.toString());
    }
}