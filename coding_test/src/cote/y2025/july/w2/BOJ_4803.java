package cote.y2025.july.w2;

import java.util.*;
import java.io.*;

public class BOJ_4803 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int caseNum = 1;
	    
	    while (true) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        
	        if (n == 0 && m == 0) break;
	        
	        List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            
            boolean[] visited = new boolean[n + 1];
            int treeCount = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    boolean[] isTree = {true}; 
                    dfs(i, 0, graph, visited, isTree);
                    if (isTree[0]) treeCount++;
                }
            }

            sb.append("Case ").append(caseNum++).append(": ");
            if (treeCount == 0) {
                sb.append("No trees.\n");
            } else if (treeCount == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(treeCount).append(" trees.\n");
            }
        }

        System.out.print(sb);
    }

    private static void dfs(int curr, int parent, List<Integer>[] graph, boolean[] visited, boolean[] isTree) {
        visited[curr] = true;

        for (int next : graph[curr]) {
            if (next == parent) continue;

            if (visited[next]) {
                isTree[0] = false; // 사이클 발생
            } else {
                dfs(next, curr, graph, visited, isTree);
            }
        }
    }
}