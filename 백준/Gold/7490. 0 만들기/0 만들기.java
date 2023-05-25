import java.io.*;
import java.util.*;

public class Main
{
    static int T, N;

    static List<String> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < T; i++)
        {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            dfs(1, "1");
            Collections.sort(list);
            for (String s : list)
            {
                sb.append(s + "\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int index, String exp)
    {
        if (index == N)
        {
            Stack<String> stack = new Stack<>();

            for (int i = exp.length() - 1; i >= 0; i--)
            {
                char cur = exp.charAt(i);

                if (cur >= '1' && cur <= '9')
                {
                   if (stack.isEmpty() || stack.peek().equals("+") || stack.peek().equals("-"))
                   {
                       stack.push(cur + "");
                   }
                   else
                   {
                       stack.push(cur + stack.pop());
                   }
                }
                else if (cur != ' ')
                {
                    stack.push(cur + "");
                }
            }

            while (stack.size() > 1)
            {
                int n1 = Integer.parseInt(stack.pop());
                String op = stack.pop();
                int n2 = Integer.parseInt(stack.pop());
                stack.push(op.equals("+") ? (n1 + n2) + "" : (n1 - n2) + "");
            }

            if (stack.pop().equals("0"))
            {
                list.add(exp);
            }

            return;
        }

        dfs(index + 1, exp + "+" + (index + 1));
        dfs(index + 1, exp + "-" + (index + 1));
        dfs(index + 1, exp + " " + (index + 1));
    }
}
