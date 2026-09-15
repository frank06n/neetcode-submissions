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
        boolean isLast = i+1 == word.length();
        TrieNode np;

        if (c!='.')
        {
            np = ptr.children[c - 'a'];
            if (np == null) return false;
            if (isLast) return np.ends;
            return searchHelper(word, i+1, np);
        }
        
        for (int j=0; j<26; j++)
        {
            np = ptr.children[j];
            if (np == null) continue;
            if (isLast) {
                if (np.ends) return true;
                continue;
            }
            if (searchHelper(word, i+1, np)) return true;
        }
        return false;
    }
}
