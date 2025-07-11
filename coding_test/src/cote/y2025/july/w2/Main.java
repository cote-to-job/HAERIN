package cote.y2025.july.w2;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1의 친구와 그 친구의 친구
		// [[1, 2], [1, 3], [3, 4], [2, 3], [4, 5]]
		// => 2, 3, 4 초대  
		// => 3
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 상근이의 동기의 수
		int m = sc.nextInt(); // 리스트의 길이 
		
		List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a); // 무방향 그래프
        }

        int[] dist = new int[n + 1]; // 방문 여부 및 깊이 저장
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 1; // 시작점은 깊이 1 (방문 처리도 겸함)

        int ans = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (dist[cur] > 2) continue; // 친구의 친구까지만 탐색

            for (int nxt : adj.get(cur)) {
                if (dist[nxt] > 0) continue; // 이미 방문한 노드는 건너뜀
                dist[nxt] = dist[cur] + 1;
                q.add(nxt);
                ans++;
            }
        }

        System.out.println(ans);
    }
}