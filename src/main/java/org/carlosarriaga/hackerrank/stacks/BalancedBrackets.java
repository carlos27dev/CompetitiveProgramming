package org.carlosarriaga.hackerrank.stacks;

import java.util.*;

class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        if (Objects.equals(s, "") || s == null) {
            return "YES";
        }

        char[] array = s.toCharArray();

        if (array[0] == '}' || array[0] == ')' || array[0] == ']') {
            return "NO";
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Deque<Character> stack = new ArrayDeque<>();
        stack.push(array[0]);

        int i = 1;
        while (i < s.length()) {
            char current = array[i];
            if (map.containsKey(current)) {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char opener = stack.pop();
                if (current != map.get(opener)) {
                    return "NO";
                }
            }
            i++;
        }
        if (!stack.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    private BalancedBrackets() {
        throw new IllegalStateException("Utility class");
    }
}
