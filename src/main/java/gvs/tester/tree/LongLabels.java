package gvs.tester.tree;

import java.util.HashMap;
import java.util.Map;

import gvs.business.tree.GVSTreeWithCollection;
import gvs.model.tree.TestBinaryNode;

public class LongLabels {
  private static Map<Integer, TestBinaryNode> nodes = new HashMap<>();
  private static final String LABEL = "loooooongLabelForTrees";

  public static void main(String[] args) {
    initNodes();
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection("Long Labels Tree Test");
    nodes.values().forEach(node -> gvsTree.add(node));
    gvsTree.display();
    gvsTree.disconnect();
  }

  private static void initNodes() {
    for (int i = 1; i < 20; i++) {
      TestBinaryNode node = createOrGetNode(i);
      TestBinaryNode leftChild = createOrGetNode(2 * i);
      TestBinaryNode rightChild = null;
      if (i != 9) {
        rightChild = createOrGetNode(2 * i + 1);
      }
      node.setLeftChild(leftChild);
      node.setRightChild(rightChild);
    }
  }

  private static TestBinaryNode createOrGetNode(int i) {
    TestBinaryNode node = nodes.get(i);
    if (node == null) {
      node = createNode(i);
    }
    return node;
  }

  private static TestBinaryNode createNode(int i) {
    TestBinaryNode node = new TestBinaryNode(LABEL + i, null);
    nodes.put(i, node);
    return node;
  }

}
