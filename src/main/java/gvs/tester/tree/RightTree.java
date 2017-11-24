package gvs.tester.tree;

import java.util.HashMap;
import java.util.Map;

import gvs.model.tree.TestBinaryNode;
import gvs.tree.GVSTreeWithCollection;

public class RightTree {
  static Map<String, TestBinaryNode> nodes = new HashMap<>();

  public static void main(String[] args) {
    initNodes();
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection("Cluttered Tree");
    nodes.values().forEach(node -> gvsTree.add(node));
    gvsTree.display();
    gvsTree.disconnect();
  }

  private static void initNodes() {
    nodes.put("1", new TestBinaryNode("1", null));
    nodes.put("2", new TestBinaryNode("2", null));
    nodes.put("3", new TestBinaryNode("3", null));
    nodes.put("4", new TestBinaryNode("4", null));
    
    nodes.get("1").setRightChild(nodes.get("2"));
    nodes.get("2").setRightChild(nodes.get("3"));
    nodes.get("3").setRightChild(nodes.get("4"));
  }
}
