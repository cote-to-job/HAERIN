package cote.y2025.july.w2;

import java.util.*;
import java.io.*;

public class BOJ_5567 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); 
        }

        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>(); // [사람 번호, 깊이]
        visited[1] = true;
        q.offer(new int[]{1, 0});
        int count = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int depth = now[1];

            if (depth >= 1 && depth <= 2) count++;  // 친구 or 친구의 친구

            if (depth == 2) continue;  // 3촌부터는 제외

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, depth + 1});
                }
            }
        }

        System.out.println(count);
    }
}