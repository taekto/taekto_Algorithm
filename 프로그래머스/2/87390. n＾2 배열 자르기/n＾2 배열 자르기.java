class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)right-(int)left;
        int[] answer = new int[len+1];
        int cnt = 0;
        for(long i=left;i<=right;i++) {
            long row = i/n;
            long col = i%n;
            answer[cnt++] = Math.max((int)row+1,(int)col+1);
        }
        
        return answer;
    }
}