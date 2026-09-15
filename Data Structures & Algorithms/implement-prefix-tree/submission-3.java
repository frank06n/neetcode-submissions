class TrieNode
{
    TrieNode[] children;
    boolean ends;

    TrieNode() {
        children = new TrieNode[26];
        ends = false;
    }
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode ptr = root;

        for (int i=0; i < word.length(); i++)
        {
            int ci = word.charAt(i)-'a';
            
            if (ptr.children[ci] == null)
                ptr.children[ci] = new TrieNode();
            
            ptr = ptr.children[ci];
        }

        ptr.ends = true;
    }

    public boolean search(String word) {
        return searchHelper(word, true);
    }

    public boolean startsWith(String prefix) {
        return searchHelper(prefix, false);
    }

    boolean searchHelper(String prefix, boolean checkEnds)
    {
        TrieNode ptr = root;

        for (int i=0; i<prefix.length(); i++) 
        {
            int ci = prefix.charAt(i)-'a';
            ptr = ptr.children[ci];
            if (ptr == null) return false;
        }

        return !checkEnds || ptr.ends;
    }
}
