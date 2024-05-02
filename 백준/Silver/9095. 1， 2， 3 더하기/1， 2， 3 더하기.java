import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i=4;i<=11;i++) {
            arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
        }

        for(int tc=1;tc<=T;tc++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
    }
}