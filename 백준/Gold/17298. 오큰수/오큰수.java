import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static Stack<Integer> ans = new Stack<>();
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            stack1.add(Integer.parseInt(st.nextToken()));
        }


        while(cnt != N) {
            if(stack2.isEmpty()) {
                stack2.add(stack1.pop());
                ans.add(-1);
                cnt++;
            }
            else {
                if(!stack1.isEmpty()) {
                    if(stack1.peek() < stack2.peek()) {
                        ans.add(stack2.peek());
                        stack2.add(stack1.pop());
                        cnt++;
                    }
                    else {
                        if(!stack2.isEmpty()) {
                            stack2.pop();
                        }
                    }
                }
                else {
                    ans.add(-1);
                    cnt++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!ans.isEmpty()) {
            sb.append(ans.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}