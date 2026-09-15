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
        if (ptr == null) return false;
        if (i == word.length()) return ptr.ends;

        char c = word.charAt(i);

        if (c!='.')
        {
            return searchHelper(word, i+1, ptr.children[c - 'a']);
        }
        
        for (int j=0; j<26; j++)
        {
            if (searchHelper(word, i+1, ptr.children[j])) return true;
        }
        
        return false;
    }
}
