class TrieNode
{
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

        for (int i=0; i < word.length(); i++)
        {
            int ci = word.charAt(i)-'a';
            
            if (ptr.children[ci] == null)
                ptr.children[ci] = new TrieNode();
            
            ptr = ptr.children[ci];
        }

        ptr.ends = true;
    }

    public boolean search(String word)
    {    
        return searchHelper(word, 0, root);
    }

    boolean searchHelper(String word, int i, TrieNode ptr)
    {
        char c = word.charAt(i);
        if (c=='.')
        {
            boolean last = i+1 == word.length();
            for (int j=0; j<26; j++)
            {
                TrieNode xptr = ptr.children[j];
                if (xptr == null) continue;
                if (last) {
                    if (xptr.ends) return true;
                    continue;
                }
                if (searchHelper(word, i+1, xptr)) return true;
            }
            return false;
        }

        TrieNode nptr = ptr.children[c - 'a'];
        if (nptr == null) return false;
        if (i+1 == word.length()) return nptr.ends;
        return searchHelper(word, i+1, nptr);
    }
}
