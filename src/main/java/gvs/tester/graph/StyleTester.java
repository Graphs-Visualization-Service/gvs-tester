package gvs.tester.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gvs.business.graph.GVSDefaultVertex;
import gvs.business.graph.GVSGraph;
import gvs.business.graph.GVSUndirectedEdge;
import gvs.business.styles.GVSColor;
import gvs.business.styles.GVSIcon;
import gvs.business.styles.GVSLineStyle;
import gvs.business.styles.GVSLineThickness;
import gvs.business.styles.GVSStyle;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestUndirectedEdge;

public class StyleTester {
  private static List<GVSDefaultVertex> vertices = new ArrayList<>();
  private static List<GVSUndirectedEdge> edges = new ArrayList<>();

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Style Tester");
    createVertices(graph);
    createEdges(graph);
    graph.display();
    addArrows();
    graph.display();
    graph.disconnect();
  }

  private static void addArrows() {
    Random rnd = new Random();
    edges.forEach(e -> ((TestUndirectedEdge) e).setArrow(rnd.nextBoolean()? 2: 1));
  }

  private static void createEdges(GVSGraph graph) {
    int j = 1;
    for (int i = 0; i < 4; i++) {
      TestUndirectedEdge e = new TestUndirectedEdge(vertices.get(i),
          vertices.get(j), i + "");
      edges.add(e);
      graph.add(e);
      j++;
      j %= 4;
    }
    ((TestUndirectedEdge) edges.get(0)).setStyle(
        new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED, GVSLineThickness.BOLD));
    ((TestUndirectedEdge) edges.get(1)).setStyle(
        new GVSStyle(GVSColor.BLUE, GVSLineStyle.DOTTED, GVSLineThickness.SLIGHT));
    ((TestUndirectedEdge) edges.get(2)).setStyle(
        new GVSStyle(GVSColor.WHITE, GVSLineStyle.THROUGH, GVSLineThickness.FAT));
    ((TestUndirectedEdge) edges.get(3)).setStyle(
        new GVSStyle(GVSColor.DARKGREY, GVSLineStyle.THROUGH, GVSLineThickness.STANDARD));
  }

  private static void createVertices(GVSGraph graph) {
    TestDefaultVertex v1 = new TestDefaultVertex("v1",
        new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED, GVSLineThickness.FAT,
            GVSColor.BLUE, GVSIcon.GLASS));
    vertices.add(v1);
    graph.add(v1);
    TestDefaultVertex v2 = new TestDefaultVertex("v2",
        new GVSStyle(GVSColor.WHITE, GVSLineStyle.DOTTED, GVSLineThickness.BOLD,
            GVSColor.YELLOW));
    vertices.add(v2);
    graph.add(v2);
    TestDefaultVertex v3 = new TestDefaultVertex("v3",
        new GVSStyle(GVSColor.GREEN, GVSLineStyle.THROUGH,
            GVSLineThickness.SLIGHT, GVSColor.GREY));
    vertices.add(v3);
    graph.add(v3);
    TestDefaultVertex v4 = new TestDefaultVertex("v4",
        new GVSStyle(GVSColor.GREEN, GVSLineStyle.THROUGH,
            GVSLineThickness.STANDARD, GVSColor.GREY));
    vertices.add(v4);
    graph.add(v4);

  }
}
