class TrieNode {
    TrieNode[] children;
    boolean ends;

    TrieNode() {
        children = new TrieNode[26];
        ends = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode ptr = root;

        for (int i = 0; i < word.length(); i++) {
            int ci = word.charAt(i) - 'a';

            if (ptr.children[ci] == null)
                ptr.children[ci] = new TrieNode();

            ptr = ptr.children[ci];
        }

        ptr.ends = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    boolean searchHelper(String word, int i, TrieNode ptr) {
        if (i == word.length())
            return ptr.ends;

        char c = word.charAt(i);

        if (c != '.') {
            TrieNode next = ptr.children[c - 'a'];

            if (next == null)
                return false;

            return searchHelper(word, i + 1, next);
        }

        for (TrieNode next : ptr.children) {
            if (next != null && searchHelper(word, i + 1, next))
                return true;
        }

        return false;
    }
}
