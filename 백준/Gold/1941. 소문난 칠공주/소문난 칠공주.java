import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static char[][] map;
    static int[] arr;
    static int ans = 0;
    static boolean[][] visited;
    static int[] dy = {-1, 1 ,0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int dasom = 0;
    static void func(int depth, int idx) {
        if(depth == 7) {
            dasom = 0;
            for(int i=0;i<7;i++) {
                int y = arr[i]/5;
                int x = arr[i]%5;
                visited[y][x] = true;
            }
            if(bfs(arr[0]/5, arr[0]%5)) ans++;
            for(int i=0;i<7;i++) {
                int y = arr[i]/5;
                int x = arr[i]%5;
                visited[y][x] = false;
            }
            return;
        }

        for(int i=idx;i<25;i++) {
            arr[depth] = i;
            func(depth+1, i+1);
        }
    }

    static boolean bfs(int y, int x) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] mark = new boolean[5][5];
        q.add(new Node(y,x));
        mark[y][x] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            y = cur.y;
            x = cur.x;
            if(map[y][x] == 'S') dasom++;
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue;
                if(visited[ny][nx] && !mark[ny][nx]) {
                    mark[ny][nx] = true;
                    q.add(new Node(ny, nx));
                    cnt++;
                }
            }
        }
        if(cnt == 7 && dasom >= 4) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        visited = new boolean[5][5];
        arr = new int[7];
        for(int i=0;i<5;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<5;j++) {
                map[i][j] = str.charAt(j);
            }
        }
        func(0,0);
        System.out.println(ans);
    }
}