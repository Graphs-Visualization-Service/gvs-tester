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
    removeVertex(graph);
    graph.display();
    addVertex(graph);
    graph.display();
    addEdge(graph);
    graph.display();
    removeEdge(graph);
    graph.display();
    createUndirectedWithArrow(graph);
    graph.display();
    graph.disconnect();
  }

  private static void createUndirectedWithArrow(GVSGraph graph) {
    int length = vertices.size();
    TestUndirectedEdge e = new TestUndirectedEdge(vertices.get(length-1),
        vertices.get(length-2),"e");
    undirectedEdges.add(e);
    graph.add(e);
    graph.display();
    e.setArrow(2);
    graph.display();
    e.setArrow(1);
  }

  private static void removeEdge(GVSGraph graph) {
    GVSDirectedEdge e = directedEdges.remove(directedEdges.size()-1);
    graph.remove(e);
  }

  private static void addEdge(GVSGraph graph) {
    int length = vertices.size();
    TestDirectedEdge e = new TestDirectedEdge(vertices.get(length-1),
        vertices.get(length-2),"e");
    directedEdges.add(e);
    graph.add(e);
  }

  private static void addVertex(GVSGraph graph) {
    TestRelativeVertex v = new TestRelativeVertex(90, 90, "new");
    vertices.add(v);
    graph.add(v);
  }

  private static void removeVertex(GVSGraph graph) {
    GVSRelativeVertex v = vertices.remove(0);
    graph.remove(v);
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
      TestRelativeVertex v = new TestRelativeVertex(i * i + 1 * 10 % 100,
          i * 2 + 5 * 10 % 100, "v" + i);
      vertices.add(v);
      graph.add(v);
    }
  }

}
