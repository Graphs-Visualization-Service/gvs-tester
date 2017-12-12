package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.model.tree.TestBinaryNode;
import gvs.styles.GVSColor;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;
import gvs.tree.GVSBinaryTreeNode;
import gvs.tree.GVSTreeWithCollection;

public class BinaryTree {

  private static List<GVSBinaryTreeNode> vertices = new ArrayList<>();

  public static void main(String[] args) {
    GVSTreeWithCollection tree = new GVSTreeWithCollection("Binary Tree");
    createVertices(tree);
    tree.display();
    addNode(tree);
    tree.display();
    removeNode(tree);
    tree.display();
    changeStyle(tree);
    tree.display();
    tree.disconnect();
  }

  private static void changeStyle(GVSTreeWithCollection tree) {
    ((TestBinaryNode) vertices.get(1)).setStyle(new GVSStyle(GVSColor.RED,
        GVSLineStyle.DASHED, GVSLineThickness.SLIGHT));
    ((TestBinaryNode) vertices.get(3)).setStyle(new GVSStyle(GVSColor.BLUE,
        GVSLineStyle.DOTTED, GVSLineThickness.FAT, GVSColor.ORANGE));
  }

  private static void removeNode(GVSTreeWithCollection tree) {
    GVSBinaryTreeNode node = vertices.get(4);
    removeNode(tree, node);
  }

  private static void removeNode(GVSTreeWithCollection tree,
      GVSBinaryTreeNode node) {
    GVSBinaryTreeNode left = node.getGVSLeftChild();
    GVSBinaryTreeNode right = node.getGVSRightChild();
    if (left != null) {
      removeNode(tree, left);
    }
    if (right != null) {
      removeNode(tree, right);
    }
    vertices.remove(node);
    tree.remove(node);

  }

  private static void addNode(GVSTreeWithCollection tree) {
    TestBinaryNode v = new TestBinaryNode("new");
    vertices.add(v);
    ((TestBinaryNode) vertices.get(1)).setRightChild(v);
    tree.add(v);
  }

  private static void createVertices(GVSTreeWithCollection tree) {
    TestBinaryNode v1 = new TestBinaryNode("v1");
    vertices.add(v1);
    TestBinaryNode v2 = new TestBinaryNode("v2");
    vertices.add(v2);
    TestBinaryNode v3 = new TestBinaryNode("v3");
    vertices.add(v3);
    TestBinaryNode v4 = new TestBinaryNode("v4");
    vertices.add(v4);
    TestBinaryNode v5 = new TestBinaryNode("v5");
    vertices.add(v5);
    TestBinaryNode v6 = new TestBinaryNode("v6");
    vertices.add(v6);
    TestBinaryNode v7 = new TestBinaryNode("v7");
    vertices.add(v7);
    TestBinaryNode v8 = new TestBinaryNode("v8");
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
