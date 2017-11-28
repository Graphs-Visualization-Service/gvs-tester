package gvs.tester.tree;

import gvs.model.tree.TestBinaryNode;
import gvs.tree.GVSTreeWithRoot;

public class RemoveRoot {
  /**
   * This creates a problem in GVS 2.0 UI. Because no "nodes" xml tag is created
   * but the field is mandatory.
   * 
   * @param args
   */
  public static void main(String[] args) {
    GVSTreeWithRoot gvsTree = new GVSTreeWithRoot("Remove Root");
    TestBinaryNode root = new TestBinaryNode("root", null);
    gvsTree.setRoot(root);
    gvsTree.display();
    gvsTree.setRoot(null);
    gvsTree.display();
    gvsTree.disconnect();
  }
}
