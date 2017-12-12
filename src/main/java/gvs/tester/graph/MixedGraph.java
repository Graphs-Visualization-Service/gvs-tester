package gvs.tester.graph;

import java.util.ArrayList;
import java.util.List;

import gvs.business.graph.GVSDefaultVertex;
import gvs.business.graph.GVSDirectedEdge;
import gvs.business.graph.GVSGraph;
import gvs.business.graph.GVSUndirectedEdge;
import gvs.business.styles.GVSColor;
import gvs.business.styles.GVSLineStyle;
import gvs.business.styles.GVSLineThickness;
import gvs.business.styles.GVSStyle;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestDirectedEdge;
import gvs.model.graph.TestRelativeVertex;
import gvs.model.graph.TestUndirectedEdge;

public class MixedGraph {
  private static List<GVSDefaultVertex> vertices = new ArrayList<>();
  private static List<GVSDirectedEdge> directedEdges = new ArrayList<>();
  private static List<GVSUndirectedEdge> undirectedEdges = new ArrayList<>();

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Default Graph");
    createVertices(graph);
    createEdges(graph);
    graph.display();
    changeStyle();
    graph.display();
    removeVertex(graph);
    graph.display();
    addVertex(graph);
    graph.display();
    addEdge(graph);
    graph.display();
    removeEdge(graph);
    graph.display();
    graph.disconnect();
  }

  private static void removeEdge(GVSGraph graph) {
    GVSDirectedEdge e = directedEdges.remove(directedEdges.size() - 1);
    graph.remove(e);
  }

  private static void addEdge(GVSGraph graph) {
    int length = vertices.size();
    TestDirectedEdge e = new TestDirectedEdge(vertices.get(length - 1),
        vertices.get(length - 2), "e");
    directedEdges.add(e);
    graph.add(e);
  }

  private static void addVertex(GVSGraph graph) {
    TestDefaultVertex v = new TestDefaultVertex("new");
    vertices.add(v);
    graph.add(v);
  }

  private static void removeVertex(GVSGraph graph) {
    GVSDefaultVertex v = vertices.remove(0);
    graph.remove(v);
  }

  private static void changeStyle() {
    ((TestDirectedEdge) directedEdges.get(0)).setStyle(
        new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED, GVSLineThickness.BOLD));
    ((TestDefaultVertex) vertices.get(0)).setStyle(new GVSStyle(GVSColor.RED,
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
      if (i % 2 == 0) {
        TestDefaultVertex v = new TestDefaultVertex("v" + i);
        vertices.add(v);
        graph.add(v);
      } else {
        TestRelativeVertex v = new TestRelativeVertex(i * 2 + 10, i * 10 + 10,
            "v" + i);
        vertices.add(v);
        graph.add(v);
      }
    }
  }
}
