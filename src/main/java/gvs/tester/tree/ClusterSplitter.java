package gvs.tester.tree;

import java.util.Vector;

import gvs.business.tree.GVSTreeWithRoot;
import gvs.model.tree.TestBinaryNode;

public class ClusterSplitter {

  public static void main(String[] args) {

    GVSTreeWithRoot tree = new GVSTreeWithRoot("ClusterSplitter-Test");

    final int HEIGHT = 7;

    int nodes = (int) Math.pow(2, HEIGHT + 1) - 1;
    Vector<TestBinaryNode> list = new Vector<>();
    list.setSize(nodes + 1);
    for (int i = 1; i <= nodes; i++) {
      list.set(i, new TestBinaryNode("" + i, null));
    }
    int i = nodes;
    while (i > 1) {
      list.get(i / 2).setRightChild(list.get(i));
      list.get(i / 2).setLeftChild(list.get(i - 1));
      i -= 2;
    }

    list.get(1).setRightChild(null);
    list.get(2).setLeftChild(null);
    for (int j = 85; j <= 89; j++) {
      list.get(j).setLeftChild(null);
      list.get(j).setRightChild(null);
    }

    TestBinaryNode root = list.get(1);
    tree.setRoot(root);
    tree.display();
    tree.disconnect();

  }

}
