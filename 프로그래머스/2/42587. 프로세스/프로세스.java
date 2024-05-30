import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int pr;
        int location;
        public Node(int pr, int location) {
            this.pr = pr;
            this.location = location;
        }
        @Override
        public int compareTo(Node o) {
            return o.pr - this.pr;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Queue<Node> q = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++) {
            pq.add(new Node(priorities[i], i));
            q.add(new Node(priorities[i], i));
        }
        int cnt = 1;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            Node nxt = q.poll();
            if(cur.pr == nxt.pr) {
                if(location == nxt.location) return cnt;
                else cnt++;
            }
            else {
                pq.add(new Node(cur.pr, cur.location));
                q.add(new Node(nxt.pr, nxt.location));
            }
        }
        
        return answer;
    }
}