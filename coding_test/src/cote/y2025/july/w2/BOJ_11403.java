package cote.y2025.july.w2;

import java.util.*;

public class BOJ_11403 {
	
    static int n;
	static int[][] graph;
    static int[][] result;
    static boolean[] vis;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		graph = new int[n][n];
		result = new int[n][n];
		
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		        graph[i][j] = sc.nextInt();
		    }
		}
		
		for (int i = 0; i < n; i++) {
            vis = new boolean[n];
            dfs(i, i);
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
	}
	
	static void dfs(int start, int curr) {
        for (int nxt = 0; nxt < n; nxt++) {
            if (graph[curr][nxt] == 1 && !vis[nxt]) {
                vis[nxt] = true;
                result[start][nxt] = 1;
                dfs(start, nxt);
            }
        }
    }
}
