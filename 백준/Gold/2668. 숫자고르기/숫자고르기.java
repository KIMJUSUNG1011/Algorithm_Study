import java.io.*;
import java.util.*;

/*
첫째줄에서 뽑은 숫자들과 둘째줄에서 뽑은 숫자들이 같아야함
1 <= N <= 100
그래프 이용
 */

public class Main
{
    static int N;
    static List<Integer>[] graph;
    static List<Integer> answerList;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        answerList = new ArrayList<>();

        for (int i = 1; i <= N; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++)
        {
            int x = Integer.parseInt(br.readLine());
            graph[x].add(i);
        }

        for (int i = 1; i <= N; i++)
        {
            bfs(i);
        }

        System.out.println(answerList.size());

        for (int i = 0; i < answerList.size(); i++)
        {
            System.out.println(answerList.get(i));
        }
    }

    static void bfs(int start)
    {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty())
        {
            int p = q.poll();

            for (int i = 0; i < graph[p].size(); i++)
            {
                if (!visited[graph[p].get(i)])
                {
                    visited[graph[p].get(i)] = true;
                    q.offer(graph[p].get(i));
                }
                else
                {
                    answerList.add(graph[p].get(i));
                }
            }
        }
    }
}
