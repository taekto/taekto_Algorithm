import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) {
            pq.add(i);
        }
        int cnt = 0;
        while(true) {
            if(pq.size() == 1 && pq.peek() < K) {
                return -1;
            };
            if(!pq.isEmpty()) {
                if(pq.peek() >= K) break;
                else {
                    if(pq.size() >= 2) {
                        int a = pq.poll();
                        int b = pq.poll();
                        pq.add(a+b*2);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}