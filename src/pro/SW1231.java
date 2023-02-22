package pro;

import java.io.*;
import java.util.*;

public class SW1231 {

    static class Node {

        String data;
        Node left, right;

        Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {

            N = Integer.parseInt(br.readLine());
            tree = new Node[N + 1];

            for (int i = 1; i <= N; i++) {
                tree[i] = new Node("", null, null);
            }

            for (int i = 1; i <= N; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int num = Integer.parseInt(st.nextToken());
                String data = st.nextToken();
                int left = -1, right = -1;

                if (st.hasMoreTokens()) {
                    left = Integer.parseInt(st.nextToken());
                }

                if (st.hasMoreTokens()) {
                    right = Integer.parseInt(st.nextToken());
                }

                tree[num].data = data;

                if (left != -1) {
                    tree[num].left = tree[left];
                }

                if (right != -1) {
                    tree[num].right = tree[right];
                }
            }

            sb.append("#" + t + " " + inOrder(tree[1]) + "\n");
        }

        System.out.println(sb);
    }

    static String inOrder(Node cur) {

        String str = "";

        if (cur.left != null) {
            str += inOrder(cur.left);
        }

        str += cur.data;

        if (cur.right != null) {
            str += inOrder(cur.right);
        }

        return str;
    }
}
