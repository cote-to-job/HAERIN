package cote.y2025.april.w4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Collection;

public class Pccp_340210 {
	
	public String[] solution(String[] expressions) {
        List<Integer> possibleBases = new ArrayList<>();
        for (int base = 2; base <= 9; base++) {
            possibleBases.add(base);
        }

        // 1. 주어진 값이 있는 수식으로 가능한 진법 후보 좁히기
        for (String expr : expressions) {
            if (!expr.contains("X")) {
                List<Integer> newPossible = new ArrayList<>();
                for (int base : possibleBases) {
                    if (isValid(expr, base)) {
                        newPossible.add(base);
                    }
                }
                possibleBases = newPossible;
            }
        }

        List<String> result = new ArrayList<>();

        // 2. X가 있는 수식 채우기
        for (String expr : expressions) {
            String[] parts = expr.split(" ");
            String A = parts[0];
            String op = parts[1];
            String B = parts[2];
            String C = parts[4];

            if (!C.equals("X")) {
                result.add(expr);
            } else {
                Set<Integer> possibleValues = new HashSet<>();
                for (int base : possibleBases) {
                    try {
                        int a = Integer.parseInt(A, base);
                        int b = Integer.parseInt(B, base);
                        int value = op.equals("+") ? a + b : a - b;
                        if (value >= 0) { // 음수면 안 됨
                            possibleValues.add(value);
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }

                if (possibleValues.size() == 1) {
                    int val = possibleValues.iterator().next();
                    String formatted = toBase(val, Collections.min(possibleBases)); 
                    result.add(A + " " + op + " " + B + " = " + formatted);
                } else {
                    result.add(A + " " + op + " " + B + " = ?");
                }
            }
        }

        return result.toArray(new String[0]);
    }

    private boolean isValid(String expr, int base) {
        String[] parts = expr.split(" ");
        String A = parts[0];
        String op = parts[1];
        String B = parts[2];
        String C = parts[4];

        try {
            int a = Integer.parseInt(A, base);
            int b = Integer.parseInt(B, base);
            int c = Integer.parseInt(C, base);
            if (op.equals("+")) {
                return a + b == c;
            } else {
                return a - b == c;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private String toBase(int value, int base) {
        if (value == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.append(value % base);
            value /= base;
        }
        return sb.reverse().toString();
    }

	
	public static void main(String[] args) {
		Pccp_340210 sol = new Pccp_340210();
	    
	    String[] expressions = {
	        "14 + 3 = 17",
	        "13 - 6 = X",
	        "51 - 5 = 44"
	    };
	    
	    String[] answer = sol.solution(expressions);
	    for (String s : answer) {
	        System.out.println(s);
	    }
	}
}