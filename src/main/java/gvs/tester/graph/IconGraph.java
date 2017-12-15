package gvs.tester.graph;

import java.util.ArrayList;
import java.util.List;

import gvs.business.graph.GVSDefaultVertex;
import gvs.business.graph.GVSDirectedEdge;
import gvs.business.graph.GVSGraph;
import gvs.business.graph.GVSUndirectedEdge;
import gvs.business.styles.GVSColor;
import gvs.business.styles.GVSIcon;
import gvs.business.styles.GVSLineStyle;
import gvs.business.styles.GVSLineThickness;
import gvs.business.styles.GVSStyle;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestDirectedEdge;
import gvs.model.graph.TestUndirectedEdge;

public class IconGraph {

  private static List<GVSDefaultVertex> vertices = new ArrayList<>();
  private static List<GVSDirectedEdge> directedEdges = new ArrayList<>();
  private static List<GVSUndirectedEdge> undirectedEdges = new ArrayList<>();

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Icon Graph");
    createVertices(graph);
    createEdges(graph);
    graph.display();
    graph.disconnect();
  }

  private static void createEdges(GVSGraph graph) {
    int j = 1;
    for (int i = 0; i < 3; i++) {
      if (i % 2 == 0) {
        TestDirectedEdge e = new TestDirectedEdge(vertices.get(i),
            vertices.get(j), i + "");
        directedEdges.add(e);
        graph.add(e);
      } else {
        TestUndirectedEdge e = new TestUndirectedEdge(vertices.get(i),
            vertices.get(j), i + "");
        undirectedEdges.add(e);
        graph.add(e);
      }
      j++;
      j %= 3;
    }
  }

  private static void createVertices(GVSGraph graph) {
    TestDefaultVertex v = new TestDefaultVertex("anchor",
        new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED, GVSLineThickness.BOLD,
            GVSColor.BLUE, GVSIcon.ANCHOR));
    vertices.add(v);
    graph.add(v);
    TestDefaultVertex v2 = new TestDefaultVertex("",
        new GVSStyle(GVSColor.WHITE, GVSLineStyle.DASHED, GVSLineThickness.BOLD,
            GVSColor.YELLOW, GVSIcon.BELL));
    vertices.add(v2);
    graph.add(v2);
    TestDefaultVertex v3 = new TestDefaultVertex("noIcon",
        new GVSStyle(GVSColor.GREEN, GVSLineStyle.DASHED, GVSLineThickness.BOLD,
            GVSColor.GREY));
    vertices.add(v3);
    graph.add(v3);
  }
}
