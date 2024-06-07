import java.util.*;

class Solution {
    
    static boolean check(int[] number) {
        for(int i : number) {
            if(i > 0) return false;
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        int sum = 0;
        for(int i=0;i<want.length;i++) {
            hashMap.put(want[i], i);
            sum += number[i];
        }
        Queue<String> q = new ArrayDeque<>();
        if(discount.length < sum) return 0;
        for(int i=0;i<sum;i++) {
            q.add(discount[i]);
            if(hashMap.containsKey(discount[i])) {
                number[hashMap.get(discount[i])]--;
            }
        }
        if(check(number)) answer++;
        for(int i=sum;i<discount.length;i++) {
            String str = q.poll();
            q.add(discount[i]);
            if(hashMap.containsKey(str)) {
                number[hashMap.get(str)]++;
            }
            if(hashMap.containsKey(discount[i])) {
                number[hashMap.get(discount[i])]--;
            }
            if(check(number)) answer++;
        }
        
        return answer;
    }
}