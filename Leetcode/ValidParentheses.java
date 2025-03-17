// 20. Valid Parentheses

// constraints
// 1. the maximum length of s
// 2. can 's' be empty? should it be considered as valid or invalid?
// 3. does 's' contain only these three types of parentheses?

// edge cases
// 1. empty string: true
// 2. single bracket: false
// 3. only closing bracket: false
// 4. only opening bracket: false
// 5. more opening bracket
// 6. incorrect order
// 7. large input

// basic idea
// opeing bracket that appeared later should be closed earlier, so we should use stack (first in last out), put opening bracket onto stack,
// once meet a closing bracket, check the top of the stack, if it matches the closing bracket, we pop it from the stack and continue, 
// if it doesn't match or the stack is empty, return false.
// at the end, if the stack is empty, which means all bracket has been matched successfully, return true. otherwise, return false.

// coding

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> hmap = new HashMap<>();
        hmap.put('(', ')');
        hmap.put('{', '}');
        hmap.put('[', ']');
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (hmap.containsKey(c)) {
                stack.add(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    char LastOpenedBracket = stack.pop();
                    if (!hmap.get(LastOpenedBracket).equals(c)) {
                        return false;
                    }
                }
            }

        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        // 1. empty string: true
        String s1 = "";
        System.out.println(solution.isValid(s1));
        // 2. single bracket: false
        String s2 =  "(";
        System.out.println(solution.isValid(s2));
        // 3. only closing bracket: false
        // 4. only opening bracket: false
        // 5. more opening bracket
        String s5 = "(([)";
        System.out.println(solution.isValid(s5));
        // 6. incorrect order
        // 7. large input
    }
}

// testing

// time complexity
// for loop: O(n), stack operations: O(1), hashmap operations O(1)
// space complexity worst case O(n)


