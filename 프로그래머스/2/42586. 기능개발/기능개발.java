import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<progresses.length;i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int a = 100-progress;
            int b;
            if(a%speed == 0) b = a/speed;
            else b=a/speed+1;
            q.add(b);
        }
        int cur = q.peek();
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int nxt = q.poll();
            if(cur >= nxt) cnt++;
            else {
                list.add(cnt);
                cur = nxt;
                cnt = 1;
            }
        }
        list.add(cnt);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}