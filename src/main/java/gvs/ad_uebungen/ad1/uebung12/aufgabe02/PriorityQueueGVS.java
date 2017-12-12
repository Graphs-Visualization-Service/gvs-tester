/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Tue Sep 22 15:10:35 CEST 2015
 */

package gvs.ad_uebungen.ad1.uebung12.aufgabe02;
import gvs.business.styles.GVSStyle;
import gvs.business.tree.GVSBinaryTreeNode;
import gvs.business.tree.GVSTreeWithRoot;

public class PriorityQueueGVS<K extends Comparable<? super K>, V> extends PriorityQueue<K, V> {

  protected GVSTreeWithRoot gvsTree = new GVSTreeWithRoot("PriorityQueue");

  protected class PQEntryGVS extends PriorityQueue.PQEntry<K, V> implements GVSBinaryTreeNode {

    protected PQEntryGVS(K key, V value) {
      super(key, value);
    }

    public GVSBinaryTreeNode getGVSLeftChild() {
      int leftIndex = getIndex() * 2;
      return (GVSBinaryTreeNode) (leftIndex <= last ? heapArray[leftIndex] : null);
    }

    public GVSBinaryTreeNode getGVSRightChild() {
      int rightIndex = getIndex() * 2 + 1;
      return (GVSBinaryTreeNode) (rightIndex <= last ? heapArray[rightIndex] : null);
    }

    public String getNodeLabel() {
      PQEntry<K, V> e = (PQEntry<K, V>)heapArray[getIndex()];
      return e.getKey().toString() + " / " + e.getValue().toString();
    }

    private int getIndex() {
      for (int i = 0; i < heapArray.length; i++) {
        if (heapArray[i] == this) {
          return i;
        }
      }
      return -1;
    }

    @Override
    public GVSStyle getStyle() {
      return null;
    }

  } // class AdaptablePriorityQueueGVS.APQEntryGVS
  
  PriorityQueueGVS(int maxSize) {
    super(maxSize);
  }
  
  @Override
  protected PQEntry<K, V> newEntry(K key, V value) {
    return new PQEntryGVS(key, value);
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
  public void displayOnGVS() {
    gvsTree.setRoot((GVSBinaryTreeNode) heapArray[1]);
    gvsTree.display();
  }

}
 
