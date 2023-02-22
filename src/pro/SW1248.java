package pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  이진 트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고,
//  그 정점을 루트로 하는 서브 트리의 크기를 알아내는 프로그램을 작성하라.

public class SW1248 {

    static class Node {

        int data;
        Node parent, left, right;

        Node(int data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    static int T, V, E, N1, N2, commonParent;
    static Node[] tree;
    static boolean[] checkParent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            N1 = Integer.parseInt(st.nextToken());
            N2 = Integer.parseInt(st.nextToken());

            tree = new Node[V + 1];
            checkParent = new boolean[V + 1];

            for (int i = 1; i <= V; i++) {
                tree[i] = new Node(i, null, null, null);
            }

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= E; i++) {

                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                if (tree[parent].left == null) {
                    tree[parent].left = tree[child];
                } else {
                    tree[parent].right = tree[child];
                }

                tree[child].parent = tree[parent];
            }

            upStream(tree[N1]);
            upStream(tree[N2]);

            sb.append("#" + t + " " + commonParent + " " + getTreeCount(tree[commonParent]) + "\n");
        }

        System.out.println(sb);
    }

    static void upStream(Node cur) {

        if (cur == null) {
            return;
        }

        if (checkParent[cur.data]) {
            commonParent = cur.data;
            return;
        }

        checkParent[cur.data] = true;

        upStream(cur.parent);
    }

    static int getTreeCount(Node cur) {

        int cnt = 1;

        if (cur.left != null) {
            cnt += getTreeCount(cur.left);
        }

        if (cur.right != null) {
            cnt += getTreeCount(cur.right);
        }

        return cnt;
    }
}
