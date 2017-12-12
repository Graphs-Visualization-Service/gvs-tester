package gvs.tester.graph;

import java.awt.font.GraphicAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gvs.graph.GVSGraph;
import gvs.model.graph.TestRelativeVertex;
import gvs.model.graph.TestUndirectedEdge;
import gvs.styles.GVSColor;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;
import gvs.tree.GVSTreeWithCollection;

public class DijkstraMock {

  private GVSStyle unexploredEdge;
  private GVSStyle discoveredEdge;
  private GVSStyle backEdge;
  private GVSStyle unexploredVertex;
  private GVSStyle visitedVertex;
  private GVSGraph graph;
  private List<TestUndirectedEdge> edges = new ArrayList<>();
  private List<TestRelativeVertex> nodes = new ArrayList<>();

  public DijkstraMock() {
    unexploredEdge = new GVSStyle(GVSColor.BLACK, GVSLineStyle.DOTTED,
        GVSLineThickness.SLIGHT, null, null);

    discoveredEdge = new GVSStyle(GVSColor.RED, GVSLineStyle.DOTTED,
        GVSLineThickness.STANDARD, null, null);

    backEdge = new GVSStyle(GVSColor.GREEN, GVSLineStyle.DOTTED,
        GVSLineThickness.STANDARD, null, null);

    unexploredVertex = new GVSStyle(GVSColor.BLACK, GVSLineStyle.THROUGH,
        GVSLineThickness.STANDARD, GVSColor.BLUE, null);

    visitedVertex = new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED,
        GVSLineThickness.FAT, GVSColor.RED, null);

    graph = new GVSGraph("Dijkstra");
  }

  private void buildGraph() {
    // Vertices:
    TestRelativeVertex vA = insertVertex("A", 50, 10);
    TestRelativeVertex vB = insertVertex("B", 10, 50);
    TestRelativeVertex vC = insertVertex("C", 50, 50);
    TestRelativeVertex vD = insertVertex("D", 90, 50);
    TestRelativeVertex vE = insertVertex("E", 30, 90);
    TestRelativeVertex vF = insertVertex("F", 70, 90);

    // Edges:
    insertEdge(vA, vD, 4);
    insertEdge(vA, vC, 2);
    insertEdge(vA, vB, 8);
    insertEdge(vC, vB, 7);
    insertEdge(vC, vD, 1);
    insertEdge(vC, vE, 3);
    insertEdge(vC, vF, 9);
    insertEdge(vE, vB, 2);
    insertEdge(vD, vF, 5);
    
    graph.display();
  }

  private void insertEdge(TestRelativeVertex vA, TestRelativeVertex vD, int i) {
    TestUndirectedEdge e = new TestUndirectedEdge(vA, vD, i+"");
    edges.add(e);
    graph.add(e);
  }

  private TestRelativeVertex insertVertex(String string, int x, int y) {
    TestRelativeVertex v = new TestRelativeVertex( x, y, string);
    nodes.add(v);
    graph.add(v);
    return v;
  }
  
  public GVSGraph getGraph() {
    return graph;
  }
  
  public static void main(String[] args) {
    DijkstraMock dijkstra = new DijkstraMock();
    dijkstra.buildGraph();
    dijkstra.animate();
    dijkstra.getGraph().disconnect();
  }

  private void animate() {
    Random r = new Random();
    int nodeMaxIndex = nodes.size();
    int edgeMaxIndex = edges.size();
    for (int i = 0 ; i < 50; i++) {
      nodes.get(r.nextInt(nodeMaxIndex)).setStyle(visitedVertex);
      nodes.get(r.nextInt(nodeMaxIndex)).setStyle(unexploredVertex);
      edges.get(r.nextInt(edgeMaxIndex)).setStyle(discoveredEdge);
      edges.get(r.nextInt(edgeMaxIndex)).setStyle(unexploredEdge);
      edges.get(r.nextInt(edgeMaxIndex)).setStyle(backEdge);
      edges.get(r.nextInt(edgeMaxIndex)).setArrow(1);
      graph.display();
    }
    
  }

}
