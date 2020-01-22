package tao.data.structure.simple.trie;

import java.util.*;

/**
 * leetcode 1268
 */
class Solution1 {
    class Node{
        boolean isWord;
        Node[] children = new Node[26];
        String word;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord){
        Node root = buildTrie(products);
        List<List<String>> finalResult = new ArrayList<>();
        for (int i=0; i<searchWord.length(); i++){
            String target = searchWord.substring(0,i+1);
            final List<String> result = find(root, target);
            finalResult.add(result);
        }
        return finalResult;
    }

    private List<String> find(Node root, String target) {
        char[] searchArray = target.toCharArray();
        Node p =root;
        for (int i=0; i<searchArray.length;i++){
            if (p.children[searchArray[i]-'a']!=null){
                p=p.children[searchArray[i]-'a'];
            }else{
                return Collections.emptyList();
            }
        }
        List<String> result = new ArrayList<>();
        dfs(p, result);
        return result;
    }

    private void dfs(Node p, List<String> result) {
        if (result.size()==3) return;
        if (p.isWord){
            result.add(p.word);
        }
        for (int i=0; i<26;i++){
            if (p.children[i]!=null){
                dfs(p.children[i], result);
            }
        }
    }

    Node buildTrie(String[] products){
        Node root = new Node();
        for (int i=0; i<products.length; i++){
            insert(root, products[i]);
        }
        return root;
    }

    void insert(Node root, String product){
        char[] charArray = product.toCharArray();
        Node p = root;
        for (int j=0; j<charArray.length;j++){
            char c = charArray[j];
            if (p.children[c-'a']==null){
                p.children[c-'a']= new Node();
            }
            p=p.children[c-'a'];
        }

        p.isWord = true;
        p.word = product;
    }

    public static void main(String[] args) {
        String[] products= {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        Solution1 solution1 = new Solution1();
        final List<List<String>> lists = solution1.suggestedProducts(products, searchWord);
        lists.forEach(x->{
            x.forEach(System.out::println);
            System.out.println("=========");
        });
    }
}