package cote.y2025.july.w1;

import java.io.*;
import java.util.*;

public class BOJ_1781 {

	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<int[]> homeworks = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			int deadline = Integer.parseInt(input[0]);
			int reward = Integer.parseInt(input[1]);
			homeworks.add(new int[]{deadline, reward});
		}
		
		homeworks.sort((a, b) -> { 
			if (a[0] != b[0]) return a[0] - b[0];
//			return b[1] - a[1];
			return 0;
		});
		
//		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		
		for (int[] hw : homeworks) {
			pq.offer(hw);
			if (pq.size() > hw[0]) {
				pq.poll(); 
			}
		}
		
		// pq = [1, 6], [1, 7] -> pq.poll() -> pq = [1, 7]
		// pq = [2, 4], [2, 5], [1, 7] -> pq.poll() -> pq = [2, 5], [1, 7] 
		// pq = [3, 1], [3, 2], [2, 5], [1, 7] -> pq.poll() -> pq = [3, 2], [2, 5], [1, 7]
		// pq = [6, 1], [3, 2], [2, 5], [1, 7]
		
		int totalReward = 0; 
		for (int[] hw : pq) {
			totalReward += hw[1];
		}
		System.out.println(totalReward);
	}

}

/*

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> homeworkList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int deadline = sc.nextInt();
            int reward = sc.nextInt();
            homeworkList.add(new int[]{deadline, reward});
        }

        // 데드라인 오름차순, 리워드 내림차순 정렬
        homeworkList.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int[] hw : homeworkList) {
            pq.offer(hw);
            if (pq.size() > hw[0]) {
                pq.poll();
            }
        }

        int totalReward = 0;
        for (int[] hw : pq) {
            totalReward += hw[1];
        }
        System.out.println(totalReward);
    }
}

*/