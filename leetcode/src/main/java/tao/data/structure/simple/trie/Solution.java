package tao.data.structure.simple.trie;

class Solution {
    static class Node{
        boolean isword;
        Node[] children=new Node[26];
        String word;
    }

    int maxDepth = 0;
    String finalWord;

    public String longestWord(String[] words) {
        Node root = new Node();
        for (int i=0; i<words.length;i++){
            insert(words[i], root);
        }
        for (int i=0; i<26;i++){
            if (root.children[i]!=null){
                dfs(root.children[i], 1);
            }
        }
        return finalWord;
    }

    void insert(String word, Node root){
        char[] wordArray = word.toCharArray();
        Node p = root;
        for (int i=0; i< wordArray.length; i++){
            if (p.children[wordArray[i] - 'a'] ==null){
                p.children[wordArray[i] - 'a'] = new Node();
            }
            p= p.children[wordArray[i] - 'a'];
        }
        p.isword =true;
        p.word = word;
    }

    void dfs(Node p, int depth){
        if (!p.isword) return;
        if (depth> maxDepth){
            //System.out.println("depth is:"+depth +", word is:"+p.word);
            finalWord = p.word; //build word
            maxDepth=depth;
        }

        for (int i=0; i<26; i++){
            Node current = p.children[i];
            if (current != null){
                dfs(current, depth+1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words =
                {"ts","e","x","pbhj","opto","xhigy","erikz","pbh","opt","erikzb",
                        "eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"};
        final String result = solution.longestWord(words);
        System.out.println(result);
    }
}