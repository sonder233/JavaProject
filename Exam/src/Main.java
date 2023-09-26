import java.util.Stack;

public class Main {
    /*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "({[]})"
输出：true
 */
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("({[]})"));
    }
    public static boolean isValid(String word){
        if (word.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        stack.push(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (   (c == ')' && stack.peek() == '(')
                || (c == ']' && stack.peek() == '[')
                || (c == '}' && stack.peek() == '{')){
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        if (stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
