package gvs;

import gvs.styles.GVSStyle;
import gvs.tree.GVSBinaryTreeNode;

class TreeNode implements GVSBinaryTreeNode {
  Object mObj;
  TreeNode mLeft;
  TreeNode mRigth;

  public TreeNode(Object pObj, TreeNode pLeft, TreeNode pRigth) {
    mObj = pObj;
    mLeft = pLeft;
    mRigth = pRigth;
  }

  void setLeft(TreeNode pLeft) {
    mLeft = pLeft;
  }

  TreeNode getLeft() {
    return mLeft;
  }

  void setRigth(TreeNode pRigth) {
    mRigth = pRigth;
  }

  TreeNode getRigth() {
    return mRigth;
  }

  @Override
  public GVSBinaryTreeNode getGVSLeftChild() {
    return getLeft();
  }

  @Override
  public GVSBinaryTreeNode getGVSRightChild() {
    return getRigth();
  }

  @Override
  public String getNodeLabel() {
    return mObj.toString();
  }

  @Override
  public GVSStyle getStyle() {
    return null;
  }

}
