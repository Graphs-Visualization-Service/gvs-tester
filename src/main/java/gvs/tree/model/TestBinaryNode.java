package gvs.tree.model;

import gvs.tree.GVSBinaryTreeNode;
import gvs.typ.node.GVSNodeTyp;

public class TestBinaryNode implements GVSBinaryTreeNode {
  String label;
  GVSNodeTyp type;
  GVSBinaryTreeNode leftChild;
  GVSBinaryTreeNode rigthChild;

  public TestBinaryNode(String label, GVSNodeTyp type) {
    this.label = label;
    this.type = type;
  }

  @Override
  public String getNodeLabel() {
    return label;
  }

  @Override
  public GVSNodeTyp getNodeTyp() {
    return type;
  }

  @Override
  public GVSBinaryTreeNode getGVSLeftChild() {
    return leftChild;
  }

  @Override
  public GVSBinaryTreeNode getGVSRigthChild() {
    return rigthChild;
  }

  public void setRightChild(GVSBinaryTreeNode child) {
    this.rigthChild = child;
  }

  public void setLeftChild(GVSBinaryTreeNode child) {
    this.leftChild = child;
  }

}
