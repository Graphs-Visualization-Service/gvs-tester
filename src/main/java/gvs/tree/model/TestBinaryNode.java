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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((label == null) ? 0 : label.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TestBinaryNode other = (TestBinaryNode) obj;
    if (label == null) {
      if (other.label != null)
        return false;
    } else if (!label.equals(other.label))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return label;
  }
  
  
}
