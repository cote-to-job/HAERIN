package cote.y2025.july.w1;

import java.util.*;

public class BOJ_1927 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 연산의 개수 (1 <= n <= 100_000)		
		// x: 자연수 => 배열에 x라는 값을 추가하는 연산
		// x: 0 => 배열에서 가장 작은 값 출력 배열에서 그 값 제거
		// 최솟값 제거는 우선순위큐가 적절
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (x > 0) {
				pq.add(x);
			} else {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					int min = pq.poll();
					System.out.println(min);
				}
			}
		}
	}
}
