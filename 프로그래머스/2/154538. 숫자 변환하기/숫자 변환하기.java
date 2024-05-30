import java.util.*;

class Solution {
    
    static int[] arr = new int[10000001];
    static int INF = 0x3f3f3f3f;
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Arrays.fill(arr, INF);
        arr[x] = 0;
        for(int i=x;i<=1000000;i++) {
            arr[i+n] = Math.min(arr[i]+1, arr[i+n]);
            arr[3*i] = Math.min(arr[i]+1, arr[3*i]);
            arr[2*i] = Math.min(arr[i]+1, arr[2*i]);
        }
        if(arr[y] == INF) {
            answer = -1;
        }
        else {
            answer = arr[y];
        }
        return answer;
    }
}