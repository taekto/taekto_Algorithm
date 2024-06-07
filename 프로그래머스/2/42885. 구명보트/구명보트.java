import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int st = 0;
        int ed = people.length-1;
        visited = new boolean[people.length];
        while(st <= ed) {
            int stWeight = people[st];
            int edWeight = people[ed];
            if(st == ed) {
                if(stWeight <= limit) {
                    answer++;
                    break;
                }
            }
            if(stWeight + edWeight <= limit) {
                answer++;
                st++;
                ed--;
            }
            else {
                answer++;
                ed--;
            }
        }
        
        return answer;
    }
}