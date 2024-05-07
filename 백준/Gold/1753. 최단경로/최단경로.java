import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int V,E,K;
    static int INF = 0x3f3f3f3f;
    static List<Node>[] list;
    static int[] dist;

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        dist[K] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.vertex] != cur.cost) continue;
            for(Node nxt : list[cur.vertex]) {
                if(dist[nxt.vertex] <= dist[cur.vertex]+nxt.cost) continue;
                dist[nxt.vertex] = dist[cur.vertex]+nxt.cost;
                pq.add(new Node(nxt.vertex, dist[nxt.vertex]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        dist = new int[V+1];
        Arrays.fill(dist, INF);
        for(int i=1;i<=V;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, cost));
        }

        dijkstra();
        for(int i=1;i<=V;i++) {
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}