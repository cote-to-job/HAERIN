package cote.y2025.june.w2;

import java.util.Scanner;

public class BOJ_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        dp[1] = 0; // 1은 이미 1이므로 연산 0번

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // 기본: 1을 뺀 경우

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);

		/*
		int answer = 0;
		while (x != 1) {	
				x = x - 1; 
				answer++;
				System.out.println(x);
				
			if (x % 2 == 0) {
				x = x / 2;
				answer++;
				System.out.println(x);
			} else if (x % 3 == 0) {
				x = x / 3;
				answer++;
				System.out.println(x);
			}
		}
		System.out.println(answer);
		*/
	}
}
