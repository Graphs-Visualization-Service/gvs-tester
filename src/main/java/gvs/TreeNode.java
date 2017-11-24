package gvs;


import gvs.tree.GVSBinaryTreeNode;
import gvs.typ.node.GVSNodeTyp;

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
  
  
  public GVSBinaryTreeNode getGVSLeftChild() {
    return getLeft();
  }
  public GVSBinaryTreeNode getGVSRigthChild() {
    return getRigth();    
  }
  public String getNodeLabel() {
    return mObj.toString();
  }
  public GVSNodeTyp getNodeTyp() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
