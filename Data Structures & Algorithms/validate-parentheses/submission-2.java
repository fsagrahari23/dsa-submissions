class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                st.push(c);

            } else if (c == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    return false;
                }

            } else if (c == ']') {
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }

            } else if (c == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }

            i++;
        }

        return st.isEmpty();
    }
}