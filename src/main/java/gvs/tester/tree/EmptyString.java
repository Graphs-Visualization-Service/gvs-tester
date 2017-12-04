package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.model.tree.TestBinaryNode;
import gvs.styles.GVSColor;
import gvs.styles.GVSIcon;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;
import gvs.tree.GVSBinaryTreeNode;
import gvs.tree.GVSTreeWithCollection;

public class EmptyString {

  private static List<GVSBinaryTreeNode> vertices = new ArrayList<>();

  public static void main(String[] args) {
    GVSTreeWithCollection tree = new GVSTreeWithCollection("Empty String");
    createVertices(tree);
    tree.display();
    tree.disconnect();
  }

  private static void createVertices(GVSTreeWithCollection tree) {
    TestBinaryNode v1 = new TestBinaryNode("");
    vertices.add(v1);
    TestBinaryNode v2 = new TestBinaryNode(null);
    vertices.add(v2);
    TestBinaryNode v3 = new TestBinaryNode("v3");
    vertices.add(v3);
    
    v1.setLeftChild(v2);
    v1.setRightChild(v3);
    tree.add(vertices);
  }
}