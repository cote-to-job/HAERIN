package cote.y2025.july.w2;

import java.util.*;
import java.io.*;

public class BOJ_1707 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int v = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    
		    List<Integer>[] graph = new ArrayList[v + 1]; 
		    int[] group = new int[v + 1]; // 0: 미방문, 1: a, -1: b 
		    
		    for (int j = 1; j < v + 1; j++) {
		        graph[j] = new ArrayList<>();
		    }
		    
		    for (int m = 0; m < e; m++) {
		        st = new StringTokenizer(br.readLine());
		        int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
		    }
		    
		    boolean isValid = true;
		    
		    for (int n = 1; n < v + 1; n++) {
		        if (group[n] == 0) {
		            if (!dfs(n, 1, group, graph)) {
		                isValid = false;
		                break;
		            }
		        }
		    }
		    
		    sb.append(isValid ? "YES\n" : "NO\n");
		}
		
		System.out.print(sb);

	}
	
	private static boolean dfs(int node, int curr, int[] group, List<Integer>[] graph) {
	    group[node] = curr;
	    
	    for (int x : graph[node]) {
	        if (group[x] == 0) {
	            if (!dfs(x, -curr, group, graph)) {
	                return false;
	            }
	        } else if (group[x] == group[node]) {
	            return false;
	        }
	    }
	    
	    return true;
	}

}
