package gvs.tester.tree;

import java.util.HashMap;
import java.util.Map;

import gvs.model.tree.TestBinaryNode;
import gvs.tree.GVSTreeWithCollection;

public class LeftTree {
  static Map<String, TestBinaryNode> nodes = new HashMap<>();

  public static void main(String[] args) {
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection("Left Tree");
    gvsTree.display();
    initNodes();
    nodes.values().forEach(node -> gvsTree.add(node));
    gvsTree.display();
    gvsTree.disconnect();
  }

  private static void initNodes() {
    nodes.put("1", new TestBinaryNode("1", null));
    nodes.put("2", new TestBinaryNode("2", null));
    nodes.put("3", new TestBinaryNode("3", null));
    nodes.put("4", new TestBinaryNode("4", null));
    nodes.put("5", new TestBinaryNode("5", null));
    nodes.put("6", new TestBinaryNode("6", null));
    
    nodes.get("1").setLeftChild(nodes.get("2"));
    nodes.get("2").setLeftChild(nodes.get("3"));
    nodes.get("3").setLeftChild(nodes.get("4"));
    nodes.get("4").setLeftChild(nodes.get("5"));
    nodes.get("5").setLeftChild(nodes.get("6"));
  }
}
