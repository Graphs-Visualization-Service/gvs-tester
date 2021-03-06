/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Sep 26 11:27:35 CEST 2016
 */

package gvs.ad_uebungen.ad2.uebung03;

import gvs.business.styles.GVSStyle;
import gvs.business.tree.GVSBinaryTreeNode;
import gvs.business.tree.GVSTreeWithRoot;

public class BinarySearchTreeGVS<K extends Comparable<? super K>, V>
    extends BinarySearchTree<K, V> {

  protected GVSTreeWithRoot gvsTree = new GVSTreeWithRoot("BinaryTreeTestGVS");

  protected class NodeGVS extends BinarySearchTree<K, V>.Node
      implements GVSBinaryTreeNode {

    protected NodeGVS(Entry<K, V> entry) {
      super(entry);
    }

    public GVSBinaryTreeNode getGVSLeftChild() {
      return (GVSBinaryTreeNode) getLeftChild();
    }

    public GVSBinaryTreeNode getGVSRightChild() {
      return (GVSBinaryTreeNode) getRightChild();
    }

    public String getNodeLabel() {
      Entry<K, V> e = getEntry();
      return e.getKey().toString() + " / " + e.getValue().toString();
    }

    @Override
    public GVSStyle getStyle() {
      return null;
    }

  } // class BinaryTreeTestGVS.NodeGVS

  @Override
  protected Node newNode(Entry<K, V> entry) {
    return new NodeGVS(entry);
  }

  @Override
  public Entry<K, V> insert(K key, V value) {
    Entry<K, V> newEntry = new Entry<K, V>(key, value);
    root = insert(root, newEntry);
    gvsTree.setRoot((GVSBinaryTreeNode) root);
    gvsTree.display();
    return newEntry;
  }

  @Override
  public Entry<K, V> remove(Entry<K, V> entry) {
    Entry<K, V> deletedEntry = super.remove(entry);
    gvsTree.display();
    return deletedEntry;
  }

}
