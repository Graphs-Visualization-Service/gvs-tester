package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.model.tree.TestBinaryNode;
import gvs.styles.GVSColor;
import gvs.styles.GVSIcon;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;
import gvs.tree.GVSBinaryTreeNode;
import gvs.tree.GVSTreeWithCollection;

public class StyleTester {
  private static List<GVSBinaryTreeNode> vertices = new ArrayList<>();

  public static void main(String[] args) {
    GVSTreeWithCollection tree = new GVSTreeWithCollection("Style Tester");
    createVertices(tree);
    tree.display();
    tree.disconnect();
  }

  private static void createVertices(GVSTreeWithCollection tree) {
    TestBinaryNode v1 = new TestBinaryNode("v1",
        new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED, GVSLineThickness.FAT,
            GVSColor.BLUE, GVSIcon.GLASS));
    vertices.add(v1);
    TestBinaryNode v2 = new TestBinaryNode("v2",
        new GVSStyle(GVSColor.WHITE, GVSLineStyle.DOTTED, GVSLineThickness.BOLD,
            GVSColor.YELLOW));
    vertices.add(v2);
    TestBinaryNode v3 = new TestBinaryNode("v3",
        new GVSStyle(GVSColor.GREEN, GVSLineStyle.THROUGH,
            GVSLineThickness.SLIGHT, GVSColor.GREY));
    vertices.add(v3);
    TestBinaryNode v4 = new TestBinaryNode("v4",
        new GVSStyle(GVSColor.GREEN, GVSLineStyle.THROUGH,
            GVSLineThickness.STANDARD, GVSColor.GREY));
    vertices.add(v4);
    TestBinaryNode v5 = new TestBinaryNode("v5",
        new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED, GVSLineThickness.FAT,
            GVSColor.BLUE, GVSIcon.GLASS));
    vertices.add(v5);
    v1.setLeftChild(v2);
    v1.setRightChild(v3);
    v3.setLeftChild(v4);
    v4.setRightChild(v5);
    tree.add(vertices);
  }
}
