package gvs.tester.tree;

import java.util.ArrayList;
import java.util.List;

import gvs.model.tree.TestDefaultNode;
import gvs.tree.GVSDefaultTreeNode;
import gvs.tree.GVSTreeWithCollection;

public class DefaultTree {

  private static List<GVSDefaultTreeNode> vertices = new ArrayList<>();

  public static void main(String[] args) {
    GVSTreeWithCollection tree = new GVSTreeWithCollection("Default Tree");
    createVertices(tree);
    tree.display();
    tree.disconnect();
  }

  private static void createVertices(GVSTreeWithCollection tree) {
    TestDefaultNode v1 = new TestDefaultNode("v1");
    vertices.add(v1);
    TestDefaultNode v2 = new TestDefaultNode("v2");
    vertices.add(v2);
    TestDefaultNode v3 = new TestDefaultNode("v3");
    vertices.add(v3);
    TestDefaultNode v4 = new TestDefaultNode("v4");
    vertices.add(v4);
    TestDefaultNode v5 = new TestDefaultNode("v5");
    vertices.add(v5);
    TestDefaultNode v6 = new TestDefaultNode("v6");
    vertices.add(v6);
    TestDefaultNode v7 = new TestDefaultNode("v7");
    vertices.add(v7);
    TestDefaultNode v8 = new TestDefaultNode("v8");
    vertices.add(v8);
    
    v1.addChild(v2);
    v1.addChild(v3);
    v1.addChild(v4);
    v1.addChild(v5);
    v1.addChild(v6);
    v3.addChild(v7);
    v3.addChild(v8);
    
    tree.add(vertices);
  }
}
