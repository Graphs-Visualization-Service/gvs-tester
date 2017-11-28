package gvs;

import gvs.styles.GVSColor;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;
import gvs.tree.GVSTreeWithRoot;

public class TestBinaryTreeRootMix {

  GVSStyle startTyp = new GVSStyle(GVSColor.BLUE, GVSLineStyle.THROUGH,
      GVSLineThickness.STANDARD, GVSColor.RED);

  GVSStyle middleTyp = new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED,
      GVSLineThickness.STANDARD, GVSColor.BLUE);

  public static void main(String[] args) {
    TestBinaryTreeRootMix test = new TestBinaryTreeRootMix();

    // test.leftTree();
    // test.rigthTree();
    test.normalTree();
    // test.TreeWithCycle();
    // test.emptyTree();
  }

  public void leftTree() {
    // LeftTree
    MyBinaryNode n1 = new MyBinaryNode("node1", startTyp, null, null);
    MyBinaryNode n2 = new MyBinaryNode("node2", startTyp, n1, null);
    MyBinaryNode n3 = new MyBinaryNode("node3", startTyp, n2, null);
    MyBinaryNode n4 = new MyBinaryNode("node4", startTyp, n3, null);
    MyBinaryNode n5 = new MyBinaryNode("node5", startTyp, n4, null);
    MyBinaryNode n6 = new MyBinaryNode("node6", startTyp, n5, null);
    MyBinaryNode n7 = new MyBinaryNode("node7", startTyp, n6, null);
    MyBinaryNode n8 = new MyBinaryNode("node8", startTyp, n7, null);

    GVSTreeWithRoot leftTree = new GVSTreeWithRoot("Links Baum");
    leftTree.setRoot(n8);

    leftTree.display();
    leftTree.disconnect();

  }

  public void rigthTree() {
    // RigthTree
    MyBinaryNode r1 = new MyBinaryNode("1", startTyp, null, null);
    MyBinaryNode r2 = new MyBinaryNode("2", startTyp, null, r1);
    MyBinaryNode r3 = new MyBinaryNode("3", startTyp, null, r2);
    MyBinaryNode r4 = new MyBinaryNode("4", startTyp, null, r3);
    MyBinaryNode r5 = new MyBinaryNode("5", startTyp, null, r4);
    MyBinaryNode r6 = new MyBinaryNode("6", startTyp, null, r5);
    MyBinaryNode r7 = new MyBinaryNode("7", startTyp, null, r6);
    MyBinaryNode r8 = new MyBinaryNode("8", startTyp, null, r7);

    GVSTreeWithRoot rigthTree = new GVSTreeWithRoot("Rechts Baum");

    rigthTree.setRoot(r3);
    rigthTree.display();
    rigthTree.setRoot(r4);
    rigthTree.display();
    rigthTree.setRoot(r5);
    rigthTree.display();
    rigthTree.setRoot(r6);
    rigthTree.display();
    rigthTree.setRoot(r7);
    rigthTree.display();
    rigthTree.setRoot(r8);
    rigthTree.display();

    // rigthTree.setMaxLabelLength(2);
    // rigthTree.display();
    // rigthTree.setMaxLabelLength(60);
    // rigthTree.display();

    r8.setStyle(middleTyp);
    rigthTree.display();
    r7.setStyle(middleTyp);
    rigthTree.display();
    r6.setStyle(middleTyp);
    rigthTree.display();
    r5.setStyle(middleTyp);
    rigthTree.display();
    r4.setStyle(middleTyp);
    rigthTree.display();
    r3.setStyle(middleTyp);
    rigthTree.display();
    r2.setStyle(middleTyp);
    rigthTree.display();
    r1.setStyle(middleTyp);
    rigthTree.display();
    rigthTree.disconnect();
  }

  public void normalTree() {
    // Normal Binary Tree
    MyBinaryNode nr13 = new MyBinaryNode("node1fffffffffffff3", startTyp, null,
        null);
    MyBinaryNode nr14 = new MyBinaryNode("node14", startTyp, null, nr13);
    MyBinaryNode nr15 = new MyBinaryNode("node15", startTyp, null, nr14);
    MyBinaryNode nr1 = new MyBinaryNode("node1", startTyp, null, null);
    MyBinaryNode nr2 = new MyBinaryNode("node2", startTyp, nr1, null);
    // MyBinaryNode nr3 = new MyBinaryNode("node3",startTyp,null,null);
    MyBinaryNode nr4 = new MyBinaryNode("node4", startTyp, nr2, null);
    MyBinaryNode nr5 = new MyBinaryNode("node5", startTyp, nr4, null);
    MyBinaryNode nr7 = new MyBinaryNode("node7", startTyp, null, nr15);
    MyBinaryNode nr8 = new MyBinaryNode("node8", startTyp, null, nr7);
    MyBinaryNode nr9 = new MyBinaryNode("node9", startTyp, nr5, null);
    MyBinaryNode nr10 = new MyBinaryNode("node10", startTyp, null, nr8);
    MyBinaryNode nr11 = new MyBinaryNode("node11", startTyp, nr9, null);
    MyBinaryNode nr12 = new MyBinaryNode("node12", startTyp, nr11, nr10);

    GVSTreeWithRoot normal = new GVSTreeWithRoot("Normaler Baum");
    // normal.setMaxLabelLength(1);

    normal.setRoot(nr12);
    normal.display();
    normal.disconnect();
  }

  public void TreeWithCycle() {
    GVSTreeWithRoot cycle = new GVSTreeWithRoot("CycleTree");
    MyBinaryNode no1 = new MyBinaryNode("nod1", startTyp, null, null);
    MyBinaryNode no2 = new MyBinaryNode("nod2", startTyp, null, no1);
    MyBinaryNode no3 = new MyBinaryNode("nod3", startTyp, no1, null);
    MyBinaryNode no4 = new MyBinaryNode("nod4", startTyp, no3, no2);
    cycle.setRoot(no4);
    cycle.display();
    cycle.disconnect();
  }

  public void emptyTree() {
    GVSTreeWithRoot empty = new GVSTreeWithRoot("Empty");
    empty.display();
    empty.disconnect();
  }
}
