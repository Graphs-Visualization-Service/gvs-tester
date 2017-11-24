package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.model.tree.TestBinaryNode;
import gvs.tree.GVSTreeWithCollection;

public class NormalTree {
  static List<TestBinaryNode> nodes = new ArrayList<>();

  public static void main(String[] args) {
    initNodes();
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection("Normal Tree");
    nodes.forEach(node -> gvsTree.add(node));
    gvsTree.display();
    gvsTree.disconnect();
  }

  private static void initNodes() {
    TestBinaryNode root = new TestBinaryNode("root", null);
    TestBinaryNode node1 = new TestBinaryNode("1", null);
    TestBinaryNode node2 = new TestBinaryNode("2", null);
    TestBinaryNode node3 = new TestBinaryNode("3", null);
    TestBinaryNode node4 = new TestBinaryNode("4", null);
    root.setLeftChild(node1);
    root.setRightChild(node2);
    node1.setRightChild(node3);
    node2.setLeftChild(node4);
    nodes.add(root);
    nodes.add(node1);
    nodes.add(node2);
    nodes.add(node3);
    nodes.add(node4);
  }
}
