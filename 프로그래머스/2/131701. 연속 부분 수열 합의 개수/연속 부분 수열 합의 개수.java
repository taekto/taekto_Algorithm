import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int i=1;i<=elements.length;i++) {
            for(int j=0;j<elements.length;j++) {
                int sum = 0;
                for(int k=j;k<j+i;k++) {
                    sum += elements[k%elements.length];
                }
                hashSet.add(sum);
            }
        }
        
        return hashSet.size();
    }
}