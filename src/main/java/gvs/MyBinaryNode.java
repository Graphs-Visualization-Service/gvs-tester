package gvs;

import gvs.tree.GVSBinaryTreeNode;
import gvs.typ.node.GVSNodeTyp;

/*
 * Created on 17.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyBinaryNode implements GVSBinaryTreeNode {

  String label;
  GVSNodeTyp typ;
  GVSBinaryTreeNode left;
  GVSBinaryTreeNode rigth;

  public MyBinaryNode(String pLabel, GVSNodeTyp pTyp) {
    this(pLabel, pTyp, null, null);
  }

  public MyBinaryNode(String pLabel, GVSNodeTyp pTyp, GVSBinaryTreeNode pLeft,
      GVSBinaryTreeNode pRigth) {
    label = pLabel;
    typ = pTyp;
    left = pLeft;
    rigth = pRigth;

  }

  public GVSBinaryTreeNode getGVSLeftChild() {
    return left;
  }

  public GVSBinaryTreeNode getGVSRigthChild() {
    return rigth;
  }

  public String getNodeLabel() {
    return label;
  }

  public GVSNodeTyp getNodeTyp() {
    return typ;
  }

  public void setTyp(GVSNodeTyp typ) {
    this.typ = typ;
  }

}
