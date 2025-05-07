package cote.y2025.may.w1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Kakao_258711 {
	
	Map<Integer, List<Integer>> graph = new HashMap<>();
	Set<Integer> visited = new HashSet<>();
	int nodeCount = 0;
	int edgeCount = 0;
	

	public int[] solution(int[][] edges) {
		
		
		
		Map<Integer, Integer> inDeg = new HashMap<>();
		Map<Integer, Integer> outDeg= new HashMap<>();
		
		for (int[] edge : edges) {
			int from = edge[0], to = edge[1];
			graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
			outDeg.put(from, outDeg.getOrDefault(from, 0) + 1);
			inDeg.put(to, inDeg.getOrDefault(to, 0) + 1);
			graph.putIfAbsent(to, new ArrayList<>());
		}
		
		int root = -1;
		for (int node : graph.keySet()) {
			if (inDeg.getOrDefault(node, 0) == 0 && outDeg.getOrDefault(node, 0) >= 2) {
                root = node;
                break;
            }
		}
		
		int donut = 0, bar = 0, eight = 0;
		
		for (int next : graph.get(root)) {
            if (visited.contains(next)) continue;

            nodeCount = 0;
            edgeCount = 0;
            dfs(next);

            int cycleCount = edgeCount - nodeCount + 1;

            if (cycleCount == 0 && edgeCount == nodeCount - 1) bar++;
            else if (cycleCount == 1 && edgeCount == nodeCount) donut++;
            else if (cycleCount == 2 && edgeCount == nodeCount + 1) eight++;
        }
		
		return new int[]{root, donut, bar, eight};
    }
	
	private void dfs(int node) {
		visited.add(node);
		nodeCount++;
		for (int next : graph.getOrDefault(node, new ArrayList<>())) {
			edgeCount++;
			if (!visited.contains(next)) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) {
		
		int[][][] edgesCases = {
				{
					{2, 3}, {4, 3}, {1, 1}, {2, 1}
				},
				
				{
					{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8},
					{9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
				}
		};
		
		for (int i = 0; i < edgesCases.length; i++) {
	        Kakao_258711 sol = new Kakao_258711(); // 인스턴스 새로 생성 (visited, graph 초기화 필요)
	        int[] result = sol.solution(edgesCases[i]);
	        System.out.println("Test Case " + (i + 1) + " → " + Arrays.toString(result));
	    }

	}

}
