import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[1001];
        arr[1] = 1;
        arr[2] = 3;
        for(int i=3;i<=1000;i++) {
            arr[i] = (arr[i-2]*2+arr[i-1])%10007;
        }
        System.out.println(arr[n]);
    }
}