/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Nov 14 14:44:02 CET 2016
 */

package gvs.ad_uebungen.ad2.uebung08;

import java.util.LinkedList;
import java.util.List;

import gvs.business.styles.GVSStyle;
import gvs.business.tree.GVSDefaultTreeNode;

class TrieNode<V> implements GVSDefaultTreeNode{

  private String keySubstr;
  private LinkedList<V> values;
  private LinkedList<TrieNode<V>> children;

  public TrieNode() {
    this.keySubstr = "";
    this.values = new LinkedList<V>();
    this.children = new LinkedList<TrieNode<V>>();
  }

  public String getKeySubstr() {
    return keySubstr;
  }

  public void setKeySubstr(String keySubstr) {
    this.keySubstr = keySubstr;
  }
  
  public List<TrieNode<V>> getChildren() {
    return children;
  }

  public List<V> getValues() {
    return values;
  }

  @Override
  public String getNodeLabel() {
    return keySubstr;
  }

  @Override
  public GVSStyle getStyle() {
    return null;
  }

  @Override
  public GVSDefaultTreeNode[] getGVSChildNodes() {
    GVSDefaultTreeNode[] array = new GVSDefaultTreeNode[children.size()];
    for (int i = 0; i < children.size(); i++) {
      array[i] = children.get(i);
    }
    return array;
  }

}
 
 
 
