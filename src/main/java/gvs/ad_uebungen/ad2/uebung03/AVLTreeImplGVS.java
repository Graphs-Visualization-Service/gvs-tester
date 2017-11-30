/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Oct  3 12:44:53 CEST 2016
 */

package gvs.ad_uebungen.ad2.uebung03;

import gvs.tree.GVSBinaryTreeNode;
import gvs.tree.GVSTreeWithRoot;
import gvs.styles.GVSStyle;

class AVLTreeImplGVS<K extends Comparable<? super K>, V> extends
    AVLTreeImpl<K, V> {

  protected GVSTreeWithRoot gvsTree; 
  
  private final int DELAY = 200;

  protected class AVLNodeGVS extends AVLTreeImpl<K, V>.AVLNode implements GVSBinaryTreeNode {

    protected AVLNodeGVS(Entry<K, V> entry) {
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
      return e.getKey() + " "+ e.getValue();
      //return e.getKey().toString();
    }

    @Override
    public GVSStyle getStyle() {
      return null;
    }

  } // class BinaryTreeTestGVS.NodeGVS

 
  AVLTreeImplGVS() {
    this("AVLTreeGVS");
  }
  
  AVLTreeImplGVS(String title) {
    gvsTree = new GVSTreeWithRoot(title);
  }
  
  @Override
  protected Node newNode(Entry<K, V> entry) {
    return new AVLNodeGVS(entry);
  }
  
  @Override
  public V put(K key, V value) {
    V result = super.put(key, value);
    gvsTree.setRoot((GVSBinaryTreeNode) root);
    gvsTree.display();
    try {Thread.sleep(DELAY);} catch (InterruptedException e) {} 
    return result;
  }

}
 