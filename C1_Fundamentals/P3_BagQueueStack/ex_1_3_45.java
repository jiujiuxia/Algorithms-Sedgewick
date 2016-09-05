package P3_BagQueueStack;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 9/4/16.
 * hint:1.3.3 1.3.8
 */
public class ex_1_3_45 {
    public static void main(String[] args) throws Exception {
        String s = "1-2-3---4";
        if (isUnderflow(s))
            StdOut.println("will cause underflow");
        String s2 = "0465381729";
        if (!isGenerable(s2))
            StdOut.println("String can not be generated by stack");
    }

    public static boolean isGenerable(String s) {
        Stack<Character> s1 = new Stack<>();
        char pushed = '0';
        for (char c : s.toCharArray()) {
            if (!s1.isEmpty() && c == s1.peek())
                s1.pop(); //if the interger is in the stack, then pop it.
            else {//otherwise  push the next integer in the input sequence onto the stack (or stop if N-1 has already been pushed)
                for (char i = pushed; i < c; i++) {
                    s1.push(i);
                }
            }
            pushed = pushed > c ? pushed : (char) (c + 1);
        }
        return s1.isEmpty();
    }

    public static boolean isUnderflow(String s) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == '-') {
                i--;
                if (i < 0)
                    return true;
            } else
                i++;
        }
        return false;
    }

}
