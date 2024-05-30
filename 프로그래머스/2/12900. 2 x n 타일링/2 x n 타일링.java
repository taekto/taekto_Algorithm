class Solution {
    
    static int[] arr = new int[60001];
    
    public int solution(int n) {
        int answer = 0;
        arr[1] = 1;
        arr[2] = 2;
        
        for(int i=3;i<=60000;i++) {
            arr[i] = (arr[i-2]%1000000007+arr[i-1]%1000000007)%1000000007;
        }
        answer = arr[n];
        return answer;
    }
}