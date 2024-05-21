import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }
    static int V, E;
    static int[] parent;
    static List<Node> list;
    static int find(int a) {
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = parent[a];
        b = parent[b];
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        parent = new int[V+1];
        for(int i=1;i<=V;i++) {
            parent[i] = i;
        }
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(from, to, cost));
        }

        Collections.sort(list);
        int ans = 0;
        for(int i=0;i<list.size();i++) {
            Node cur = list.get(i);
            int a = cur.from;
            int b = cur.to;
            int cost = cur.cost;
            if(find(a) != find(b)) {
                union(a,b);
                ans+=cost;
            }
        }
        System.out.println(ans);
    }
}