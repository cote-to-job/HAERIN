package cote.y2025.july.w1;

import java.io.*;
import java.util.*;

public class BOJ_2606 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 (노드)
		int m = Integer.parseInt(br.readLine()); // 연결된 쌍의 수 (간선)
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) { // 컴퓨터 번호는 1번부터 n번까지
			graph.add(new ArrayList<>());
		}
		
//		System.out.println(graph); 
//		[[], [], [], [], [], [], [], []]
		
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			graph.get(a).add(b);
			graph.get(b).add(a);
			
//			System.out.println(graph);
//			[[], [2], [1], [], [], [], [], []]
//			[[], [2], [1, 3], [2], [], [], [], []]
//			[[], [2, 5], [1, 3], [2], [], [1], [], []]
//			[[], [2, 5], [1, 3, 5], [2], [], [1, 2], [], []]
//			[[], [2, 5], [1, 3, 5], [2], [], [1, 2, 6], [5], []]
//			[[], [2, 5], [1, 3, 5], [2], [7], [1, 2, 6], [5], [4]]
		}
		
		boolean[] vis = new boolean[n + 1]; // 컴퓨터 번호는 1번부터 n번까지
		
//		System.out.println(graph); // [[], [2, 5], [1, 3, 5], [2], [7], [1, 2, 6], [5], [4]]
//		System.out.println(Arrays.toString(vis)); // [false, false, false, false, false, false, false, false]
		
		int count = dfs(1, graph, vis);	
		System.out.println(count - 1);
		
	}
	
	static int dfs(int node, List<List<Integer>> conn, boolean[] visited) {
		
		visited[node] = true; // 현재 노드 방문 체크
		System.out.println(Arrays.toString(visited));
		
		int count = 1; // 자기 자신 포함
		
		for (int nxt : conn.get(node)) {	
			// 방문하지 않았다면 dfs호출
			if (!visited[nxt]) { 
				count += dfs(nxt, conn, visited); // 연결된 컴퓨터 수 누적 합
				System.out.println("count = " + count);
			}
		}
		
		return count;
	}

}
