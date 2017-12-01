package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.model.tree.TestBinaryNode;
import gvs.tree.GVSBinaryTreeNode;
import gvs.tree.GVSTreeWithCollection;

public class CyclicRootCollection {

  private static List<GVSBinaryTreeNode> vertices = new ArrayList<>();

  public static void main(String[] args) {
    GVSTreeWithCollection tree = new GVSTreeWithCollection("Cyclic Tree");
    createVertices(tree);
    tree.display();
    tree.disconnect();
  }

  private static void createVertices(GVSTreeWithCollection tree) {
    TestBinaryNode v1 = new TestBinaryNode("v1");
    vertices.add(v1);
    TestBinaryNode v2 = new TestBinaryNode("v2");
    vertices.add(v2);
    TestBinaryNode v3 = new TestBinaryNode("v3");
    vertices.add(v3);
    
    v1.setLeftChild(v2);
    v2.setRightChild(v3);
    v3.setRightChild(v2);
    tree.add(vertices);
  }
}
