import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, M, N, x, y, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            answer = -1;

            int i = 0;
            while (true) {
                int v = M * (i++) + x;
                if (v > lcm(M, N)) {
                    break;
                }
                int tmpY = (v % N == 0) ? (N) : (v % N);
                if (tmpY == y) {
                    answer = v;
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    static int lcm(int x, int y) {
       return x * y / gcd(x, y);
    }

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
