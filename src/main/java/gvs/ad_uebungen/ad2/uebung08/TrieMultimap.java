/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Nov 14 14:44:02 CET 2016
 */

package gvs.ad_uebungen.ad2.uebung08;

import java.util.Iterator;
import java.util.LinkedList;

import gvs.business.tree.GVSTreeWithRoot;

public class TrieMultimap<V> implements Multimap<String, V> {

  private TrieNode<V> root;
  private GVSTreeWithRoot tree;

  private enum Mutation {
    INSERT, REMOVE
  };

  public TrieMultimap() {
    this.root = new TrieNode<V>();
    this.tree = new GVSTreeWithRoot("Trie");
    this.tree.setRoot(this.root);
  }
  
  /**
   * Returns the first value for a given key. null if key is not found.
   */
  public V find(String key) {
    TrieNode<V> result = find(root, key);
    if (result != null)
      return result.getValues().get(0);
    else
      return null;
  }

  /**
   * Returns all values for a given key.
   * 
   * @return Iterator over all values. If key is not found: Iterator without
   *         next.
   */
  public Iterator<V> findAll(String key) {
    TrieNode<V> result = find(root, key);
    if (result != null)
      return result.getValues().iterator();
    else
      return new LinkedList<V>().iterator();
  }

  private TrieNode<V> find(TrieNode<V> node, String keySubstr) {
    if (keySubstr.length() == 0) {
      return node;
    }
    for (TrieNode<V> child : node.getChildren()) {
      if (keySubstr.startsWith(child.getKeySubstr())) {
        keySubstr = keySubstr.substring(child.getKeySubstr().length());
        return find(child, keySubstr);
      }
    }
    return null;
  }

  /**
   * Inserts a key/value pair into the multimap.
   */
  public void insert(String key, V value) {
    TrieNode<V> result = find(root, key);
    if (result != null) {
      result.getValues().add(value);
    } else {
      mutate(Mutation.INSERT, root, key, 0, value);
    }
    tree.display();
  }

  private boolean mutate(Mutation operation, TrieNode<V> node, String key, 
                         int keyIndex, V value) {
    if (key.length() == keyIndex) {
      // found the node!
      if (operation == Mutation.INSERT) {
        node.getValues().add(value);
      } else { // REMOVE
        node.getValues().clear();
      }
      return true;
    }
    for (TrieNode<V> child : node.getChildren()) {
      if (child.getKeySubstr().charAt(0) == key.charAt(keyIndex)) {
        if (child.getKeySubstr().length() > 1) { // a compressed node?
          child = decompress(node, child);
        }
        boolean result = mutate(operation, child, key, ++keyIndex, value);
        compress(node, child);
        return result;
      }
    }
    // there is no corresponding child:
    if (operation == Mutation.INSERT) {
      TrieNode<V> newNode = new TrieNode<>();
      newNode.setKeySubstr(key.substring(keyIndex, keyIndex + 1));
      node.getChildren().add(newNode);
      mutate(Mutation.INSERT, newNode, key, ++keyIndex, value);
      compress(node, newNode);
    } else { // REMOVE
      return false; // not found
    }
    return false;
  }

  private TrieNode<V> decompress(TrieNode<V> node, TrieNode<V> child) {
    // insert an additional, single-char node (de-compressing):
    TrieNode<V> newChild = new TrieNode<>();
    newChild.setKeySubstr(child.getKeySubstr().substring(0, 1));
    child.setKeySubstr(child.getKeySubstr().substring(1));
    newChild.getChildren().add(child);
    node.getChildren().add(newChild);
    node.getChildren().remove(child);
    return newChild;
  }

  private void compress(TrieNode<V> node, TrieNode<V> child) {
    if ((child != root) && (child.getChildren().size() == 1) 
        && (child.getValues().isEmpty())) {
      // compress:
      TrieNode<V> childOfChild = child.getChildren().get(0);
      child.setKeySubstr(child.getKeySubstr().concat(childOfChild.getKeySubstr()));
      child.getValues().addAll(childOfChild.getValues());
      child.getChildren().addAll(childOfChild.getChildren());
      child.getChildren().remove(childOfChild);
      return;
    }
    if (child.getChildren().isEmpty() && (child.getValues().isEmpty())) {
      // this is a removed node:
      node.getChildren().remove(child);
      return;
    }
  }

  /**
   * Removes all values for a given key.
   */
  public void remove(String key) {
    TrieNode<V> result = find(root, key);
    if (result != null) {
      mutate(Mutation.REMOVE, root, key, 0, null);
    } else {
      return;
    }
    tree.display();
  }

  /**
   * Returns the number of values in the trie.
   */
  public int size() {
    return size(root);
  }

  /**
   * @return Number of values in this node and its child nodes.
   */
  private int size(TrieNode<V> element) {
    int size = 0;
    for (TrieNode<V> child : element.getChildren()) {
      size += size(child);
    }
    size += element.getValues().size();
    return size;
  }

  /**
   * Print the tree.
   */
  public void print() {
    print(0, root);
    tree.display();
  }

  /**
   * 
   * @param depth
   *          Depth in which the node is.
   * @param node
   *          Node to print.
   */
  private void print(int depth, TrieNode<V> node) {
    for (int i = 0; i < depth; i++)
      System.out.print("\t");
    System.out.print(node.getKeySubstr() + ": ");
    for (Iterator<V> iter = node.getValues().iterator(); iter.hasNext();) {
      V element = iter.next();
      System.out.print(element);
      if (iter.hasNext())
        System.out.print(", ");
    }
    System.out.println();
    for (TrieNode<V> element : node.getChildren()) {
      print(depth + 1, element);
    }
  }
  
  public GVSTreeWithRoot getTree() {
    return tree;
  }

  public static void main(String[] args) {
    TrieMultimap<String> multimap = new TrieMultimap<>();

    multimap.insert("Büro", "bureau");
    multimap.insert("Büro", "office");
    multimap.insert("Büro", "agency");
    multimap.insert("Hallo", "hello");
    multimap.insert("Held", "hero");
    multimap.insert("halten", "keep");
    multimap.insert("Hall", "hall");
    multimap.insert("Halle", "hall");
    multimap.insert("hast", "have");
    multimap.insert("Ekstase", "ecstasy");
    multimap.insert("Ecke", "corner");
    multimap.insert("Ecken", "corners");

    if (multimap.size() != 12) {
      System.err.println("wrong size after insertion");
      System.exit(1);
    }

    System.out.println("after insertion");
    multimap.print();

    System.out.println("\nfind test:");
    System.out.println(multimap.find("Büro"));
    System.out.println(multimap.find("Hallo"));
    System.out.println(multimap.find("Held"));
    System.out.println(multimap.find("halten"));
    System.out.println(multimap.find("Hall"));
    System.out.println(multimap.find("Halle"));
    System.out.println(multimap.find("hast"));
    System.out.println(multimap.find("Ekstase"));
    System.out.println(multimap.find("Ecke"));
    System.out.println(multimap.find("Ecken"));
    System.out.println(multimap.find("XYZ"));

    System.out.println("\nfindall test:");
    Iterator<String> it = multimap.findAll("Büro");
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
    System.out.println();
    System.out.println(multimap.findAll("XYZ").hasNext());

    if (multimap.size() != 12) {
      System.err.println("wrong after find routines");
      System.exit(2);
    }

    multimap.remove("Hallo");
    multimap.remove("halten");
    multimap.remove("Ecke");
    multimap.remove("hast");
    multimap.remove("H");
    System.out.println();

    if (multimap.size() != 8) {
      System.err.println("wrong after remove");
      System.exit(3);
    }
    System.out.println("after remove");
    multimap.print();
    multimap.getTree().disconnect();
  }
}
 
/* Session-Log:

after insertion
: 
        Büro: bureau, office, agency
        H: 
                eld: hero
                all: hall
                        o: hello
                        e: hall
        ha: 
                lten: keep
                st: have
        E: 
                kstase: ecstasy
                cke: corner
                        n: corners

find test:
bureau
hello
hero
keep
hall
hall
have
ecstasy
corner
corners
null

findall test:
bureau office agency 
false

after remove
: 
        Büro: bureau, office, agency
        H: 
                eld: hero
                all: hall
                        e: hall
        E: 
                kstase: ecstasy
                cken: corners

*/ 
 
