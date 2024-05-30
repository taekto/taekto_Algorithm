import java.util.*;

class Solution {
    
    static int[] arr;
    
    static class Node implements Comparable<Node> {
        int num;
        int cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Node o) {
            return o.cnt - this.cnt;
        }
    }
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        arr = new int[10000001];
        for(int i : tangerine) {
            arr[i]++;
        }
        
        List<Node> list = new ArrayList<>();
        for(int i=1;i<=10000000;i++) {
            if(arr[i] != 0) {
                list.add(new Node(i, arr[i]));
            }
        } 
        Collections.sort(list);
        
        for(int i=0;i<list.size();i++) {
            if(k <= 0) break;
            Node cur = list.get(i);
            k -= cur.cnt;
            answer++;
        }
        
        return answer;
    }
}