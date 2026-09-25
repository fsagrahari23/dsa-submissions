class TrieNode {
    TrieNode[] children = new TrieNode[52];
    boolean isEnd = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }

        return 26 + (c - 'A');
    }

    public void addWord(String word) {

        TrieNode curr = root;

        for (char c : word.toCharArray()) {

            int index = getIndex(c);

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode curr, String word, int pos) {

        if (pos == word.length()) {
            return curr.isEnd;
        }

        char c = word.charAt(pos);

        if (c != '.') {

            int index = getIndex(c);

            if (curr.children[index] == null) {
                return false;
            }

            return dfs(curr.children[index], word, pos + 1);
        }

        for (int i = 0; i < 52; i++) {

            if (curr.children[i] != null) {

                if (dfs(curr.children[i], word, pos + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}