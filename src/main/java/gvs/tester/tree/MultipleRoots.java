package gvs.tester.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gvs.model.tree.TestBinaryNode;
import gvs.tree.GVSTreeWithCollection;

public class MultipleRoots {
  static Map<String, TestBinaryNode> nodes = new HashMap<>();

  public static void main(String[] args) {
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection("Multiple Roots Tree");
//    initNodes(1, 5);
//    nodes.values().forEach(node -> gvsTree.add(node));
//    gvsTree.display();
//    nodes.clear();
    initNodes(10, 20);
    nodes.values().forEach(node -> gvsTree.add(node));
    gvsTree.display();
    gvsTree.disconnect();
  }

  private static void initNodes(int start, int end) {
    for (int i = start; i < end; i++) {
      TestBinaryNode node = createOrGetNode(i);
      TestBinaryNode leftChild = createOrGetNode(2 * i);
      TestBinaryNode rightChild = createOrGetNode(2 * i + 1);
      node.setLeftChild(leftChild);
      node.setRightChild(rightChild);
    }
  }

  private static TestBinaryNode createOrGetNode(int i) {
    TestBinaryNode node = nodes.get(Integer.toString(i));
    if (node == null) {
      node = createNode(i);
    }
    return node;
  }

  private static TestBinaryNode createNode(int i) {
    TestBinaryNode node = new TestBinaryNode(Integer.toString(i), null);
    nodes.put(node.getNodeLabel(), node);
    return node;
  }
}
