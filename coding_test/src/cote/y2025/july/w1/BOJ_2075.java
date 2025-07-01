package cote.y2025.july.w1;

import java.util.*;

public class BOJ_2075 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n * n; i++) {
			pq.add(-sc.nextInt());
		}
		
		for (int i = 0; i < n-1; i++) {
			pq.poll(); 
		}
		System.out.println(-pq.poll());

	}

}

/* 바킹독
 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 최소 힙 (기본이 오름차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n * n; i++) {
            int num = sc.nextInt();

            pq.add(num);

            if (pq.size() > n) {
                pq.poll(); // 가장 작은 수 제거
            }
        }

        // n번째로 큰 값
        System.out.println(pq.peek());
    }
}

*/