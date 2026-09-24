class Solution {
    String s;
    TrieNode root;
    HashMap<Integer, Integer> record;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        root = new TrieNode();
        record = new HashMap<>();
        for (String word : wordDict) insert(word);
        return wb(0);
    }

    void insert(String word) {
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

    boolean wb(int i)
    {
        if (i == s.length()) return true;
        if (record.containsKey(i)) return record.get(i)==1;

        TrieNode ptr = root;
        boolean matches = false;

        while (i<s.length())
        {
            ptr = ptr.children[s.charAt(i)-'a'];
            i++;
            if (ptr == null) break;
            else if (ptr.ends && wb(i)) matches = true;
        }

        record.put(i, matches ? 1 : -1);

        return matches;
    }
}

class TrieNode
{
    TrieNode[] children;
    boolean ends;

    TrieNode() {
        children = new TrieNode[26];
        ends = false;
    }
}