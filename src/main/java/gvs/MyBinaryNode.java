package gvs;

import gvs.styles.GVSStyle;
import gvs.tree.GVSBinaryTreeNode;

/*
 * Created on 17.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyBinaryNode implements GVSBinaryTreeNode {

  private String label;
  private GVSStyle style;
  private GVSBinaryTreeNode left;
  private GVSBinaryTreeNode right;

  public MyBinaryNode(String pLabel, GVSStyle style) {
    this(pLabel, style, null, null);
  }

  public MyBinaryNode(String pLabel, GVSStyle style, GVSBinaryTreeNode pLeft,
      GVSBinaryTreeNode pRight) {
    this.label = pLabel;
    this.style = style;
    this.left = pLeft;
    this.right = pRight;
  }

  @Override
  public GVSBinaryTreeNode getGVSLeftChild() {
    return left;
  }

  @Override
  public GVSBinaryTreeNode getGVSRightChild() {
    return right;
  }

  @Override
  public String getNodeLabel() {
    return label;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }

  public void setStyle(GVSStyle style) {
    this.style = style;
  }
}
