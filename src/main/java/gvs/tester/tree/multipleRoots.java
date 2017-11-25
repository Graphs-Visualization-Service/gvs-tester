package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.model.tree.TestBinaryNode;
import gvs.tree.GVSTreeWithCollection;

public class multipleRoots {
  static List<TestBinaryNode> nodes = new ArrayList<>();

  public static void main(String[] args) {
    initNodes();
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection("Multiple Roots Tree");
    nodes.forEach(node -> gvsTree.add(node));
    gvsTree.display();
    gvsTree.disconnect();
  }

  private static void initNodes() {
    TestBinaryNode root1 = new TestBinaryNode("1", null);
    TestBinaryNode root2 = new TestBinaryNode("2", null);
    TestBinaryNode root3 = new TestBinaryNode("3", null);
    nodes.add(root1);
    nodes.add(root2);
    nodes.add(root3);
  }
}
