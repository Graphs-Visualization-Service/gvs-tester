package gvs.tester.tree;

import gvs.business.tree.GVSTreeWithRoot;
import gvs.model.tree.TestBinaryNode;

public class HelloTree {

  public static void main(String[] args) {
    GVSTreeWithRoot tree = new GVSTreeWithRoot("Hello World Tree");

    TestBinaryNode root = new TestBinaryNode("root");
    TestBinaryNode left = new TestBinaryNode("left");
    TestBinaryNode right = new TestBinaryNode("right");

    root.setLeftChild(left);
    root.setRightChild(right);

    tree.setRoot(root);

    tree.display();
    tree.disconnect();
  }
}
