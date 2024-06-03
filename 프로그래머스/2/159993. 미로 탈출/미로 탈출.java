import java.util.*;

class Solution {
    
    static class Node{
        int y;
        int x;
        int cnt;
        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    
    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(stY, stX, 0));
        visited[stY][stX] = true;
        ans = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;
            if(y == levY && x == levX) ans = cnt;
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if(!visited[ny][nx] && map[ny][nx] != 'X') {
                    q.add(new Node(ny,nx,cnt+1));
                    visited[ny][nx] = true;
                }
            }
        }
        if(ans == 0) return;
        
        visited = new boolean[r][c];
        
        q = new ArrayDeque<>();
        q.add(new Node(levY, levX, ans));
        ans = 0;
        visited[levY][levX] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int cnt = cur.cnt;
            if(y == exitY && x == exitX) ans = cnt;
            for(int i=0;i<4;i++) {
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                if(!visited[ny][nx] && map[ny][nx] != 'X') {
                    q.add(new Node(ny,nx,cnt+1));
                    visited[ny][nx] = true;
                }
            }
        }
        
    }
    
    static int stY;
    static int stX;
    static int[] dy = {-1, 1 ,0 ,0};
    static int[] dx = {0, 0, -1, 1};
    static int levY;
    static int levX;
    static char[][] map;
    static boolean[][] visited;
    static int r,c;
    static int ans;
    static int exitY;
    static int exitX;
        
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        r = maps.length;
        c = maps[0].length();
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[i].length();j++) {
                map[i][j] = maps[i].charAt(j);
                if(maps[i].charAt(j) == 'S') {
                    stY = i;
                    stX = j;
                }
                else if(maps[i].charAt(j) == 'L') {
                    levY = i;
                    levX = j;
                }
                else if(maps[i].charAt(j) == 'E') {
                    exitY = i;
                    exitX = j;
                }
            }
        }
        bfs();
        if(ans == 0) return -1;
        else return ans;
    }
}