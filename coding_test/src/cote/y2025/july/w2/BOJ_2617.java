package cote.y2025.july.w2;

import java.util.*;
import java.io.*;

public class BOJ_2617 {

	public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Integer>[] light = new ArrayList[n + 1];
        List<Integer>[] heavy = new ArrayList[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            light[i] = new ArrayList<>();
            heavy[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            heavy[b].add(a); // b보다 무거운 a
            light[a].add(b); // a보다 가벼운 b
        }

        int mid = (n + 1) / 2;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            int lightCnt = dfs(i, light, visited);

            visited = new boolean[n + 1];
            int heavyCnt = dfs(i, heavy, visited);

            if (lightCnt >= mid || heavyCnt >= mid) {
                result++;
            }
        }

        System.out.println(result);
    }
    
    private static int dfs(int curr, List<Integer>[] graph, boolean[] vis) {
        vis[curr] = true;
        int count = 0;

        for (int next : graph[curr]) {
            if (!vis[next]) {
                count += 1 + dfs(next, graph, vis);
            }
        }

        return count;
    }
}