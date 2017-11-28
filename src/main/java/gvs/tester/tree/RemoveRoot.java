package gvs.tester.tree;

import gvs.MyBinaryNode;
import gvs.tree.GVSTreeWithCollection;
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
    MyBinaryNode root = new MyBinaryNode("root", null);
    gvsTree.setRoot(root);
    gvsTree.display();
    gvsTree.setRoot(null);
    gvsTree.display();
    gvsTree.disconnect();
  }
}
