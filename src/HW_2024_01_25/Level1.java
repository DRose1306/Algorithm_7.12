package HW_2024_01_25;

import java.util.Stack;

public class Level1 {
    public static void main(String[] args) {
        //Последовательность([{}])является правильной,а последовательности([)],
        // {()] правильными не являются. Докажите это используя стек!

        String str = "([{}])";
        String str2 = "([)]";
        String str3 = "{()]";

        System.out.println(isValid2(str));
        System.out.println(isValid2(str2));
        System.out.println(isValid2(str3));
    }

    
    static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false; // Несоответствие скобок
            }
        }

        return stack.isEmpty();
    }
}

