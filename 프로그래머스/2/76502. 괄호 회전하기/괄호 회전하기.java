import java.util.*;

class Solution {
    
    static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char a = str.charAt(i);
            if(a == '{' || a == '(' || a == '[') {
                stack.add(a);
            }
            else {
                if(!stack.isEmpty()) {
                    if(a == '}' && stack.peek() == '{') {
                        stack.pop();
                    }
                    else if(a == ']' && stack.peek() == '[') {
                        stack.pop();
                    }
                    else if(a == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                }
                else {
                    return false;
                }
            }
        }
        if(stack.size() == 0) return true;
        return false;
        
    }
    
    static String move(String str) {
        str = str.substring(1, str.length()) + str.substring(0,1);
        return str;
    }
    
    public int solution(String s) {
        int answer = 0;
        System.out.println(s);
        
        for(int i=0;i<s.length();i++) {
            if(check(s)) answer++;
            s = move(s);
        }
        
        return answer;
    }
}