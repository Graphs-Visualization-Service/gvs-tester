package gvs;

import java.util.ArrayList;

import gvs.styles.GVSColor;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;
import gvs.tree.GVSBinaryTreeNode;
import gvs.tree.GVSTreeWithCollection;

public class TestBinaryTreeCollection {

  GVSStyle startTyp = new GVSStyle(GVSColor.BLUE, GVSLineStyle.THROUGH,
      GVSLineThickness.STANDARD, GVSColor.RED, null);

  GVSStyle middleTyp = new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED,
      GVSLineThickness.STANDARD, GVSColor.BLUE, null);

  public static void main(String[] args) {
    TestBinaryTreeCollection test = new TestBinaryTreeCollection();
    // test.leftTree();
    // test.rigthTree();
    test.normalTree();
    // test.TreeWithRootCycle();
    // test.TreeWithCycle();
    // test.emptyTree();
  }

  public void leftTree() {
    // LeftTree

    GVSTreeWithCollection leftTree = new GVSTreeWithCollection("Links Baum");

    MyBinaryNode n1 = new MyBinaryNode("node1", null, null, null);
    MyBinaryNode n2 = new MyBinaryNode("node2", null, n1, null);
    MyBinaryNode n3 = new MyBinaryNode("node3", startTyp, n2, null);
    MyBinaryNode n4 = new MyBinaryNode("node4", startTyp, n3, null);
    MyBinaryNode n5 = new MyBinaryNode("node5", startTyp, n4, null);
    MyBinaryNode n6 = new MyBinaryNode("node6", startTyp, n5, null);
    MyBinaryNode n7 = new MyBinaryNode("node7", startTyp, n6, null);
    MyBinaryNode n8 = new MyBinaryNode("node8", startTyp, n7, null);

    leftTree.add(n1);
    leftTree.add(n2);
    leftTree.add(n3);
    leftTree.add(n4);
    leftTree.add(n5);
    leftTree.add(n6);
    leftTree.add(n7);
    leftTree.add(n8);

    leftTree.setMaxLabelLength(2);
    leftTree.setMaxLabelLength(60);

    leftTree.display();
    leftTree.disconnect();

  }

  public void rigthTree() {
    // RigthTree
    MyBinaryNode r1 = new MyBinaryNode("node1", startTyp, null, null);
    MyBinaryNode r2 = new MyBinaryNode("node2", startTyp, null, r1);
    MyBinaryNode r3 = new MyBinaryNode("node3", startTyp, null, r2);
    MyBinaryNode r4 = new MyBinaryNode("node4", startTyp, null, r3);
    MyBinaryNode r5 = new MyBinaryNode("node5", startTyp, null, r4);
    MyBinaryNode r6 = new MyBinaryNode("node6", startTyp, null, r5);
    MyBinaryNode r7 = new MyBinaryNode("node7", startTyp, null, r6);
    MyBinaryNode r8 = new MyBinaryNode("node8", startTyp, null, r7);

    GVSTreeWithCollection rigthTree = new GVSTreeWithCollection("Rechts Baum");

    rigthTree.add(r1);
    rigthTree.add(r2);
    rigthTree.add(r3);
    rigthTree.add(r4);
    rigthTree.add(r5);
    rigthTree.add(r6);
    rigthTree.add(r7);
    rigthTree.add(r8);

    rigthTree.display();
    // rigthTree.setMaxLabelLength(2);
    rigthTree.display();
    rigthTree.setMaxLabelLength(60);
    rigthTree.display();
    r1.setStyle(middleTyp);
    rigthTree.display();
    r2.setStyle(middleTyp);
    rigthTree.display();
    r3.setStyle(middleTyp);
    rigthTree.display();
    r4.setStyle(middleTyp);
    rigthTree.display();
    r5.setStyle(middleTyp);
    rigthTree.display();
    r6.setStyle(middleTyp);
    rigthTree.display();
    r7.setStyle(middleTyp);
    rigthTree.display();
    r8.setStyle(middleTyp);
    rigthTree.display();
    rigthTree.disconnect();
  }

  public void normalTree() {
    // Normal Binary Tree
    MyBinaryNode nr1 = new MyBinaryNode("node1", startTyp, null, null);
    MyBinaryNode nr2 = new MyBinaryNode("node2", startTyp, null, nr1);
    MyBinaryNode nr3 = new MyBinaryNode("node3", startTyp, null, null);
    MyBinaryNode nr4 = new MyBinaryNode("node4", startTyp, nr2, nr3);
    MyBinaryNode nr5 = new MyBinaryNode("node5", startTyp, null, nr4);

    MyBinaryNode nr7 = new MyBinaryNode("node7", startTyp, null, null);
    MyBinaryNode nr8 = new MyBinaryNode("node8", startTyp, null, nr7);
    MyBinaryNode nr9 = new MyBinaryNode("node9", startTyp, null, null);
    MyBinaryNode nr10 = new MyBinaryNode("node10", startTyp, null, nr8);
    MyBinaryNode nr11 = new MyBinaryNode("node11", startTyp, null, nr9);
    MyBinaryNode nr12 = new MyBinaryNode("node12", startTyp, nr11, nr10);

    GVSTreeWithCollection normal = new GVSTreeWithCollection(
        "Normaler Baum Coll");

    ArrayList<GVSBinaryTreeNode> l = new ArrayList<>();
    l.add(nr1);

    normal.add(l);
    normal.add(l);
    normal.display();

    l.add(nr2);

    normal.add(l);
    /*
     * normal.add(nr1); normal.add(nr2); normal.display();
     * 
     * normal.add(nr3); normal.add(nr4); normal.display();
     * 
     * normal.add(nr5); normal.add(nr7); normal.display();
     * 
     * normal.add(nr8); normal.add(nr9); normal.display();
     * 
     * normal.add(nr10); normal.add(nr11); normal.display();
     * 
     * normal.add(nr12); normal.display();
     */

    normal.display();
    normal.disconnect();
  }

  public void TreeWithCycle() {
    GVSTreeWithCollection cycle = new GVSTreeWithCollection("CycleTree");
    MyBinaryNode no1 = new MyBinaryNode("nod1", startTyp, null, null);
    MyBinaryNode no2 = new MyBinaryNode("nod2", startTyp, null, no1);
    MyBinaryNode no3 = new MyBinaryNode("nod3", startTyp, no1, null);
    MyBinaryNode no4 = new MyBinaryNode("nod4", startTyp, no3, no2);

    cycle.add(no1);
    cycle.add(no2);
    cycle.add(no3);
    cycle.add(no4);

    cycle.display();
    cycle.disconnect();
  }

  public void emptyTree() {
    GVSTreeWithCollection empty = new GVSTreeWithCollection("Empty");
    empty.display();
    empty.disconnect();
  }
}
