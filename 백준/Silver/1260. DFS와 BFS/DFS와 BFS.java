import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static List<Integer>[] list;

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(V);
        visited[V] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int nxt : list[cur]) {
                if(!visited[nxt]) {
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
        sb.append("\n");
    }

    static void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.add(V);

        while(!stack.isEmpty()) {
            int cur = stack.pop();
            if(visited[cur]) continue;
            sb.append(cur).append(" ");
            visited[cur] = true;
            for(int nxt : list[cur]) {
                if(!visited[nxt]) {
                    stack.add(nxt);
                }
            }
        }
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i=1;i<=N;i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }
        visited = new boolean[N+1];
        dfs();
        for(int i=1;i<=N;i++) {
            Collections.sort(list[i]);
        }
        visited = new boolean[N+1];
        bfs();
        System.out.println(sb.toString());
    }
}