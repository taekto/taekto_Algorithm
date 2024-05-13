import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[1000001];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=2;i<=1000000;i++) {
            arr[i] = arr[i-1]+1;
            if(i%2 == 0) arr[i] = Math.min(arr[i/2]+1, arr[i]);
            if(i%3 == 0) arr[i] = Math.min(arr[i/3]+1, arr[i]);
        }

        System.out.println(arr[N]);

    }
}