package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.model.tree.TestBinaryNode;
import gvs.tree.GVSBinaryTreeNode;
import gvs.tree.GVSTreeWithCollection;

public class SameLabels {

  private static List<GVSBinaryTreeNode> vertices = new ArrayList<>();

  public static void main(String[] args) {
    GVSTreeWithCollection tree = new GVSTreeWithCollection("Binary Tree");
    createVertices(tree);
    tree.display();
    tree.disconnect();
  }

  private static void createVertices(GVSTreeWithCollection tree) {
    TestBinaryNode v1 = new TestBinaryNode("v");
    vertices.add(v1);
    TestBinaryNode v2 = new TestBinaryNode("v1");
    vertices.add(v2);
    TestBinaryNode v3 = new TestBinaryNode("v1");
    vertices.add(v3);
    TestBinaryNode v4 = new TestBinaryNode("v1");
    vertices.add(v4);
    TestBinaryNode v5 = new TestBinaryNode("v1");
    vertices.add(v5);
    TestBinaryNode v6 = new TestBinaryNode("v1");
    vertices.add(v6);
    TestBinaryNode v7 = new TestBinaryNode("v1");
    vertices.add(v7);
    TestBinaryNode v8 = new TestBinaryNode("v1");
    vertices.add(v8);
    
    v1.setLeftChild(v2);
    v1.setRightChild(v3);
    v3.setLeftChild(v4);
    v4.setRightChild(v5);
    v5.setLeftChild(v6);
    v5.setRightChild(v7);
    v7.setLeftChild(v8);
    tree.add(vertices);
  }
}
