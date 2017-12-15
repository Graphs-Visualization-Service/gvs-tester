/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Tue Sep 22 15:10:35 CEST 2015
 */

package gvs.ad_uebungen.ad1.uebung12.aufgabe03;

import gvs.ad_uebungen.ad1.uebung12.aufgabe02.Entry;
import gvs.ad_uebungen.ad1.uebung12.aufgabe02.FullPriorityQueueException;
import gvs.business.styles.GVSStyle;
import gvs.business.tree.GVSBinaryTreeNode;
import gvs.business.tree.GVSTreeWithRoot;

public class AdaptablePriorityQueueGVS<K extends Comparable<? super K>, V>
    extends AdaptablePriorityQueue<K, V> {

  protected GVSTreeWithRoot gvsTree = new GVSTreeWithRoot(
      "AdaptablePriorityQueue");

  protected class APQEntryGVS extends AdaptablePriorityQueue.APQEntry<K, V>
      implements GVSBinaryTreeNode {

    protected APQEntryGVS(K key, V value, int index) {
      super(key, value, index);
    }

    public GVSBinaryTreeNode getGVSLeftChild() {
      int leftIndex = index * 2;
      return (GVSBinaryTreeNode) (leftIndex <= last ? heapArray[leftIndex]
          : null);
    }

    public GVSBinaryTreeNode getGVSRightChild() {
      int rightIndex = index * 2 + 1;
      return (GVSBinaryTreeNode) (rightIndex <= last ? heapArray[rightIndex]
          : null);
    }

    public String getNodeLabel() {
      APQEntry<K, V> e = (APQEntry<K, V>) heapArray[index];
      return e.getKey().toString() + " / " + e.getValue().toString();
    }

    @Override
    public GVSStyle getStyle() {
      return null;
    }

  } // class AdaptablePriorityQueueGVS.APQEntryGVS

  AdaptablePriorityQueueGVS(int maxSize) {
    super(maxSize);
  }

  @Override
  protected PQEntry<K, V> newEntry(K key, V value) {
    return new APQEntryGVS(key, value, last);
  }

  @Override
  public Entry<K, V> insert(K key, V value) throws FullPriorityQueueException {
    Entry<K, V> newEntry = super.insert(key, value);
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
    return newEntry;
  }

  @Override
  public Entry<K, V> removeMin() {
    Entry<K, V> removedEntry = super.removeMin();
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
    return removedEntry;
  }

  @Override
  public K replaceKey(Entry<K, V> entry, K newKey)
      throws InvalidEntryException {
    K oldKey = super.replaceKey(entry, newKey);
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
    return oldKey;
  }

  @Override
  public Entry<K, V> remove(Entry<K, V> entry) throws InvalidEntryException {
    Entry<K, V> removedEntry = super.remove(entry);
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
    return removedEntry;
  }

  @Override
  protected void swap(int parent, int child) {
    super.swap(parent, child);
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
  }

  @Override
  public void displayOnGVS() {
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
  }

}
