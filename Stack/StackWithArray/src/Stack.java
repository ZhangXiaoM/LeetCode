import com.sun.org.apache.regexp.internal.RE;

public class Stack {

    private String[] stack;
    private int cnt = 0;
    Stack(int cap) {
        stack = new String[cap];
    }

    private void resize(int size) {
        String[] temp = new String[size];
        for (int i = 0; i < stack.length; ++i) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public void push(String s) {
        if (stack.length == cnt) resize(stack.length * 2);
        stack[cnt ++] = s;
    }

    public String pop() {
        return stack[-- cnt];
    }
}
