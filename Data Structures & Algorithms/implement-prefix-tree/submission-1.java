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
        int i=0;
        TrieNode ptr = root;
        while (ptr != null) {
            int ci = word.charAt(i)-'a';
            TrieNode nextptr = ptr.children[ci];
            if (nextptr == null)
            {
                nextptr = new TrieNode();
                ptr.children[ci] = nextptr;
            }
            ptr = nextptr;

            if (word.length() == i+1) {
                nextptr.ends = true;
                break;
            }
            i++;
        }
    }

    public boolean search(String word) {
        int i=0;
        TrieNode ptr = root;
        while (ptr != null) {
            int ci = word.charAt(i)-'a';
            ptr = ptr.children[ci];
            if (word.length() == i+1) return ptr!=null && ptr.ends;
            i++;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        int i=0;
        TrieNode ptr = root;
        while (ptr != null) {
            int ci = prefix.charAt(i)-'a';
            ptr = ptr.children[ci];
            if (prefix.length() == i+1) return ptr!=null;
            i++;
        }
        return false;
    }
}
