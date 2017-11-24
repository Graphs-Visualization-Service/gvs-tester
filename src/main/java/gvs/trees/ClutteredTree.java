package gvs.trees;

import java.util.HashMap;
import java.util.Map;

import gvs.tree.GVSTreeWithCollection;
import gvs.tree.model.TestBinaryNode;

public class ClutteredTree {
  static Map<String, TestBinaryNode> nodes = new HashMap<>();

  public static void main(String[] args) {
    initNodes();
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection("Cluttered Tree");
    nodes.values().forEach(node -> gvsTree.add(node));
    gvsTree.display();
    gvsTree.disconnect();
  }

  private static void initNodes() {
    for (int i = 1; i < 20; i++) {
      TestBinaryNode node =  createOrGetNode(i);
      TestBinaryNode leftChild = createOrGetNode(2*i);
      TestBinaryNode rightChild = null;
      if (i != 19) {
        rightChild = createOrGetNode(2*i+1);  
      }
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
