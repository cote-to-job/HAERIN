package cote.y2025.july.w1;

// BOJ_1655
import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> lt = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rt = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder(); // 출력을 모아서 한 번에

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (lt.size() <= rt.size()) {
                lt.offer(num);
            } else {
                rt.offer(num);
            }

            if (!rt.isEmpty() && rt.peek() < lt.peek()) {
                lt.offer(rt.poll());
                rt.offer(lt.poll());
            }

            sb.append(lt.peek()).append('\n'); // 출력 버퍼에 추가
        }

        System.out.print(sb); // 한 번에 출력
    }
}
