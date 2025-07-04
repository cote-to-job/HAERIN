package cote.y2025.july.w1;

// BOJ_2606
import java.io.*;
import java.util.*;

public class Main3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int m = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>()); // [[], [], [], [], [], [], []]
		}
		
		for (int i = 0; i < m; i++) {
			String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]); 
            int b = Integer.parseInt(st[1]); 
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

	    boolean[] visited = new boolean[n + 1];
		int count = dfs(1, graph, visited);

		System.out.println(count - 1);
	}

	static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
		visited[node] = true;
		int total = 1; // 자기 자신 포함

		for (int next : graph.get(node)) {
			if (!visited[next]) {
			    total += dfs(next, graph, visited);
			}
		}
		return total;
	}

}