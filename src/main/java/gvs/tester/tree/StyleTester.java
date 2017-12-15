package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.business.styles.GVSColor;
import gvs.business.styles.GVSIcon;
import gvs.business.styles.GVSLineStyle;
import gvs.business.styles.GVSLineThickness;
import gvs.business.styles.GVSStyle;
import gvs.business.tree.GVSBinaryTreeNode;
import gvs.business.tree.GVSTreeWithCollection;
import gvs.model.tree.TestBinaryNode;

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
    TestBinaryNode v2 = new TestBinaryNode("v2", new GVSStyle(GVSColor.WHITE,
        GVSLineStyle.DOTTED, GVSLineThickness.BOLD, GVSColor.YELLOW));
    vertices.add(v2);
    TestBinaryNode v3 = new TestBinaryNode("v3", new GVSStyle(GVSColor.GREEN,
        GVSLineStyle.THROUGH, GVSLineThickness.SLIGHT, GVSColor.GREY));
    vertices.add(v3);
    TestBinaryNode v4 = new TestBinaryNode("v4", new GVSStyle(GVSColor.GREEN,
        GVSLineStyle.THROUGH, GVSLineThickness.STANDARD, GVSColor.GREY));
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
