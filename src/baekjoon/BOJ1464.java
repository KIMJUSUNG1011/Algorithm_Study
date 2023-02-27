package baekjoon;

import java.io.*;

public class BOJ1464 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 2; i < s.length(); i++) {

            String tmp = s.substring(0, i);

            // 뒤집어야 하는 경우
            if (((tmp.compareTo(reverse(tmp)) < 0) && (tmp.charAt(0) >= s.charAt(i)))
                    || ((tmp.compareTo(reverse(tmp)) > 0) && (tmp.charAt(i - 1) < s.charAt(i)))
            ) {
                s = reverse(tmp) + s.substring(i);
            }
        }

        if (s.compareTo(reverse(s)) < 0) {
            System.out.print(s);
        } else {
            System.out.print(reverse(s));
        }
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        return sb.toString();
    }
}
