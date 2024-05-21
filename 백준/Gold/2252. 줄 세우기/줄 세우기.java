import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] indegree;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=0;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        for(int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indegree[b]++;
            list[a].add(b);
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int nxt : list[cur]) {
                indegree[nxt]--;
                if(indegree[nxt] == 0) q.add(nxt);
            }
        }
        System.out.println(sb.toString());
    }
}