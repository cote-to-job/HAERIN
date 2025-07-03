package cote.y2025.july.w1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1655 {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PriorityQueue<Integer> lt = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> rt = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			lt.add(num);
			
			if (!rt.isEmpty() && lt.peek() > rt.peek()) {
				rt.add(lt.poll());
			}
			
			if (lt.size() > rt.size() + 1) {
				rt.add(lt.poll());
			} else if (rt.size() > lt.size()) {
                lt.add(rt.poll());
            }
			
			System.out.println(lt.peek());
					
		}
		
	}

}

/*

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> lt = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
		PriorityQueue<Integer> rt = new PriorityQueue<>(); // 최소 힙
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			lt.add(num);
			
			if (!rt.isEmpty() && lt.peek() > rt.peek()) {
				rt.add(lt.poll());
			}
			
			if (lt.size() > rt.size() + 1) {
				rt.add(lt.poll());
			} else if (rt.size() > lt.size()) {
				lt.add(rt.poll());
			}
			
			System.out.println(lt.peek());
		}
	}
}

*/
