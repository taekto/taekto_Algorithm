class Solution {
    
    static long[] arr;
    
    public long solution(int n) {
        long answer = 0;
        arr = new long[20001];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3;i<=2000;i++) {
            arr[i] = (arr[i-2]%1234567+arr[i-1]%1234567)%1234567;
        }
        answer = arr[n];
        return answer;
    }
}