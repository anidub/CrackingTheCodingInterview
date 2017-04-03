package Trie;

import java.util.HashMap;
import java.util.Map;
/*Trie is a tree data structure used for storing collection of strings.If two strings have a common prefix then they have a same ancestor in this tree
 * If you have thousands of strings then it is very easy to store those words in this data structure since it becomes very easy to store,search,delete
 * Ideal datastructure for strong a dictionary.Does prefix based search. Hashtable takes more space than trie.Hashtable doesnt do prefix based search.
 * or  :https://examples.javacodegeeks.com/core-java/trie-tutorial-java/
 *https://www.toptal.com/java/the-trie-a-neglected-data-structure
 */
public class Trie{
	
public class TrieNode {
	Map<Character, TrieNode> children;
	boolean endOfWord;
	public TrieNode() {
		children = new HashMap<>();
		endOfWord = false;
	}
}

private final TrieNode root;
public Trie(){
	root = new TrieNode();
}
/*
 * Iterative implementation of insert into trie
 * Complexity : O(l * n) : l = avg length of string, n = number of strings
 */
public void insert(String word){
	TrieNode current = root;
	for(int i = 0; i < word.length(); i++){
		char ch = word.charAt(i);
		TrieNode node = current.children.get(ch);
		if(node == null){
			node = new TrieNode();
			current.children.put(ch,node);
		}
		current = node;
	}
	//mark the current nodes endOfWord as true
	current.endOfWord = true;
}

/*
 * Recursive implementation of insert into Trie
 */
public void insertRecursive(String word){
	insertRecursive(root, word,0);
}

private void insertRecursive(TrieNode current, String word, int index){
	if(index==word.length()){
		//if end of word in reached then mark endOfWord as true on current node
		current.endOfWord = true;
		return;
	}
	char ch = word.charAt(index);
	TrieNode node = current.children.get(ch);
	
	//if node does not exists in map then crerate one and put it into map
	if(node == null){
		node = new TrieNode();
		current.children.put(ch, node);
	}
	insertRecursive(node, word, index + 1);
}
 
/*
 * Iterative implementation of search into Trie ... complexity : O(l)
 */
public boolean search(String word){
	TrieNode current = root;
	for(int i = 0; i < word.length(); i++){
		char ch = word.charAt(i);
		TrieNode node = current.children.get(ch);
		//if node does not exist for given char then return false
		if(node == null){
			return false;
		}
		current = node;
	}
	//return true of current's endOfWord is true else return false
	return current.endOfWord;
}

/*
 * Recursive implementation of search into trie
 */
public boolean searchRecursive(String word){
	return searchRecursive(root, word, 0);
}

	private boolean searchRecursive(TrieNode current, String word, int index) {
		if (index == word.length()) {
			// return true of current's endOfWord is true else return false
			return current.endOfWord;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		// if node does not exist for given char then return false
		if (node == null) {
			return false;
		}
		return searchRecursive(node, word, index + 1);
	}

/*
 * delete word from file
 */

public void delete(String word){
	delete(root, word, 0);
}

/*
 * return true id parent should delete mapping...complexity : O(l * n)
 */
	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			// when end of word is reached only delete if current.endOfWord is true
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			// if current has no other mapping then return true
			return current.children.size() == 0;
		}

		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		// if true is returned then delete the mapping of charatcer and trieNode reference from map.
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			// return true if no mappings are left in the map.
			return current.children.size() == 0;
		}
		return false;
	}
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("Hello");
		System.out.println(trie.search("Hello"));
		trie.delete("Hello");
		System.out.println(trie.search("Hello"));
		System.out.println(trie.search("Anish"));
	}
}
