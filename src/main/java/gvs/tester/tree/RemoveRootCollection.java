package gvs.tester.tree;


import gvs.MyBinaryNode;
import gvs.tree.GVSTreeWithCollection;

public class RemoveRootCollection {

  public static void main(String[] args) {
    GVSTreeWithCollection gvsTree = new GVSTreeWithCollection("Remove Root (Collection)");
    MyBinaryNode root = new MyBinaryNode("root", null);
    gvsTree.add(root);
    gvsTree.display();
    gvsTree.remove(root);
    gvsTree.display();
    gvsTree.disconnect();
  }
}
