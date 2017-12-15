package gvs.tester.tree;

import gvs.business.tree.GVSTreeWithCollection;
import gvs.model.tree.TestBinaryNode;

public class RemoveRootCollection {

  public static void main(String[] args) {
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection(
        "Remove Root (Collection)");
    TestBinaryNode root = new TestBinaryNode("root", null);
    gvsTree.add(root);
    gvsTree.display();
    gvsTree.remove(root);
    gvsTree.display();
    gvsTree.disconnect();
  }
}
