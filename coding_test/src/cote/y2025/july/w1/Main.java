package cote.y2025.july.w1;

// BOJ_1655
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();

	    PriorityQueue<Integer> lt = new PriorityQueue<>(Collections.reverseOrder());
	    PriorityQueue<Integer> rt = new PriorityQueue<>();

	    for (int i = 0; i < n; i++) {
	      int t = sc.nextInt();

	      if (lt.size() <= rt.size()) {
	        lt.offer(t);
	      } else {
	        rt.offer(t);
	      }

	      if (!rt.isEmpty() && rt.peek() < lt.peek()) {
	        lt.offer(lt.poll());
	        rt.offer(rt.poll());
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

        PriorityQueue<Integer> lt = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rt = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());

            if (lt.size() <= rt.size()) {
                lt.offer(t);
            } else {
                rt.offer(t);
            }

            if (!rt.isEmpty() && rt.peek() < lt.peek()) {
                rt.offer(lt.poll());
                lt.offer(rt.poll());
            }

            System.out.println(lt.peek());
        }
    }
}

*/