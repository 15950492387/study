import com.hui.niuke.test.ListNode;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        System.out.println(new TestMain().generateParenthesis(3));
    }

    public ListNode ReverseList(ListNode head) {
        if (null == head)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while (null != head) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>(10);
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(String string, int open, int close, int n, List<String> result) {
        if (string.length() == n << 1) {
            result.add(string);
            return;
        }
        if (open < n) {
            backtrack(string+"(", open+1, close, n, result);
        }
        if (close < open) {
            backtrack(string+")", open, close+1, n, result);
        }
    }



}





