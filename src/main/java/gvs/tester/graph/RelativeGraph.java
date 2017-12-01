package gvs.tester.graph;

import java.util.ArrayList;
import java.util.List;

import gvs.graph.GVSDirectedEdge;
import gvs.graph.GVSGraph;
import gvs.graph.GVSRelativeVertex;
import gvs.graph.GVSUndirectedEdge;
import gvs.model.graph.TestDirectedEdge;
import gvs.model.graph.TestRelativeVertex;
import gvs.model.graph.TestUndirectedEdge;
import gvs.styles.GVSColor;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;

public class RelativeGraph {

  private static List<GVSRelativeVertex> vertices = new ArrayList<>();
  private static List<GVSDirectedEdge> directedEdges = new ArrayList<>();
  private static List<GVSUndirectedEdge> undirectedEdges = new ArrayList<>();

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Relative Graph");
    createVertices(graph);
    createEdges(graph);
    graph.display();
    changeStyle();
    graph.display();
    graph.disconnect();
  }

  private static void changeStyle() {
    ((TestDirectedEdge) directedEdges.get(0)).setStyle(
        new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED, GVSLineThickness.BOLD));
    ((TestRelativeVertex) vertices.get(0)).setStyle(new GVSStyle(GVSColor.RED,
        GVSLineStyle.DOTTED, GVSLineThickness.SLIGHT, GVSColor.BLUE));
  }

  private static void createEdges(GVSGraph graph) {
    int j = 1;
    for (int i = 0; i < 5; i++) {
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
      j %= 4;
    }
  }

  private static void createVertices(GVSGraph graph) {
    for (int i = 0; i < 5; i++) {
      TestRelativeVertex v = new TestRelativeVertex(i * i + 1, i * 2 + 5,
          "v" + i);
      vertices.add(v);
      graph.add(v);
    }
  }

}
